package com.petproject.voting.web.profile;

import com.petproject.voting.model.Vote;
import com.petproject.voting.service.VoteService;
import com.petproject.voting.to.VoteTo;
import com.petproject.voting.util.VotesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.assureIdConsistent;
import static com.petproject.voting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = ProfileVoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileVoteRestController {
    private static final Logger log = LoggerFactory.getLogger(ProfileVoteRestController.class);

    public static final String REST_URL = "/votes";
    private final VoteService service;

    public ProfileVoteRestController(VoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<VoteTo> getAll() {
        log.info("getAll");
        return VotesUtil.getTos(service.getAllByUserId(100000));
    }

    @PostMapping(/*consumes = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity<Vote> create(/*@RequestBody VoteTo voteTo*/ @RequestParam int restaurantId) {
        if (LocalTime.now().isAfter(LocalTime.of(11,0))) {
            log.info("sorry, it's too late - {}", LocalTime.now());
            return null;
        }
        else {
            Vote vote = new Vote(LocalDate.now());
            checkNew(vote);
            log.info("create {} for restaurant {}", vote, restaurantId);

            Vote created = service.create(vote, restaurantId, 100000);
            URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(REST_URL + "/{id}")
                    .buildAndExpand(created.getId()).toUri();
            return ResponseEntity.created(uriOfNewResource).body(created);
        }
    }

    @PutMapping(value = "/{id}"/*, consumes = MediaType.APPLICATION_JSON_VALUE*/)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void update(/*@RequestBody VoteTo voteTo*/ @RequestParam int restaurantId, @PathVariable int id) {
        VoteTo voteTo = VotesUtil.createTo(service.get(id));
        if (VotesUtil.isVotedToday(voteTo) && voteTo.getUserId() == 100000) {
            log.info("update {} for id {}", voteTo, id);
            service.update(VotesUtil.createFromTo(voteTo), restaurantId, 100000);
        }
    }
}
