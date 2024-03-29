package com.spring.changementserie.Dto;

import com.spring.changementserie.Models.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private Integer idDto;
    private String nomDto;
    private String prenomDto;
    private String emailDto;
    private String passwordDto;
    public static UserDto fromEntity(User user){
        if(user==null){
            return null;
        }
    return UserDto.builder()
            .idDto(user.getId())
            .nomDto(user.getFirstName())
            .prenomDto(user.getLastName())
            .emailDto(user.getEmail())
            .passwordDto(user.getPassword())
                    .build();
}
public static UserDto toEntity(UserDto userDto){
        if(userDto==null){
            return null;
        }
        User user=new User();
        user.setId(userDto.getIdDto());
        user.setFirstName(userDto.getNomDto());
        user.setEmail(userDto.getEmailDto());
        user.setPassword(userDto.getPasswordDto());
    return userDto;
    }

}
