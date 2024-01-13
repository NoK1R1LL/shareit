package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("POST /users : create user from DTO - {}", userDto);
        return userService.createUser(userDto);
    }

    @PatchMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id,
                              @RequestBody UserDto userDto) {
        log.info("PATCH /users/{} : update user by ID from DTO - {}", id, userDto);
        return userService.updateUser(userDto, id);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        log.info("GET /users/{} : get user by ID", id);
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("GET /users : get list of all users");
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("DELETE /users/{} : delete user by ID", id);
        userService.deleteUser(id);
    }

}