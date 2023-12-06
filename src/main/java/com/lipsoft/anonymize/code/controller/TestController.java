package com.lipsoft.anonymize.code.controller;

import com.lipsoft.anonymize.code.dto.AppUserDTO;
import com.lipsoft.anonymize.code.dto.AppUserResponseDTO;
import com.lipsoft.anonymize.code.service.database.AddressService;
import com.lipsoft.anonymize.code.service.database.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
//@RequestMapping("/api")
public class TestController {

    private final UserService userService;
    private final AddressService addressService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/load",
            consumes = { "application/json" }
    )
    ResponseEntity<Void> saveAppUser(@RequestBody final AppUserDTO appUserDTO) {
        userService.saveUser(appUserDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user"
//            consumes = { "application/json" }
    )
    ResponseEntity<List<AppUserResponseDTO>> getAllAppUser() {
        System.out.println("pam pam ============================================ 2");
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getAllAppUsers());
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/user/{user-id}"
//            consumes = { "application/json" }
    )
    ResponseEntity<Void> getAllAppUser(@PathVariable(name = "user-id") Long userId) {
        userService.removeById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // it should be in new controller

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/address/{address-id}"
//            consumes = { "application/json" }
    )
    ResponseEntity<Void> removeAddressById(@PathVariable(name = "address-id") Long addressId) {
        addressService.removeAddressById(addressId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
