package com.example.MyPlayList2022.shared.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
//    // generate User id
//    public String generateUserId(int length) {
//        return generateRandomString(length);
//    }
    
    
    
    // generate PlayList id 
    public String generatePlayListId(int length) {
		return generateRandomString(length);
	}

    
    // generate Video id
	public String generateVideoId(int length) {
		return generateRandomString(length);
	}
	

    // generate RANDOM String
    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
        
    }

}
