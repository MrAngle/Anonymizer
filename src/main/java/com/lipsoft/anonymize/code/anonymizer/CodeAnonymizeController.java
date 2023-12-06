package com.lipsoft.anonymize.code.anonymizer;

import com.lipsoft.anonymize.code.anonymizer.DTO.AddAnonymizationRuleRequest;
import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizeRequest;
import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/anonymizer")
public class CodeAnonymizeController {

    private IAnonymizerRepositoryActions anonymizerRepositoryActions;
    private Anonymizer anonymizerHandler;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = {"application/json"}
    )
    ResponseEntity<Void> saveAnonymizationRule(
            @RequestBody final AddAnonymizationRuleRequest addAnonymizationRuleRequest) {

        anonymizerRepositoryActions.createAnonymizationRule(addAnonymizationRuleRequest.getAnonymizationRule());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    ResponseEntity<List<AnonymizerDTO>> getAllAppUser() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(anonymizerRepositoryActions.getAnonymizationRules());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/anonymize"
    )
    ResponseEntity<String> anonymize(@RequestBody final AnonymizeRequest anonymizeRequest) {
        log.info("anonymize action");
        String results = anonymizerHandler.anonymizeText(anonymizeRequest.getTextToAnonymize());
        return ResponseEntity.status(HttpStatus.OK)
                .body(results);
    }

}
