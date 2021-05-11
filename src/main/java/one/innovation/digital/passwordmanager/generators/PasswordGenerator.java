package one.innovation.digital.passwordmanager.generators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordGenerator {

    private boolean specialChar;

    private boolean numChar;

    private boolean alphabeticChar;

    private int passLength;

    public String passGen(){

        StringBuilder generatedPassword = new StringBuilder();

        String specCharacters = "!@#$%&/(){}[]_:*?<>";

        int specCharactersLength = specCharacters.length();

        int specValidation = 0;
        int numValidation = 0;
        int upperValidation = 0;
        int lowerValidation = 0;

        if (specialChar && numChar && alphabeticChar){

            generatedPassword = specNumAlphChar(generatedPassword, specCharacters, specCharactersLength, specValidation, numValidation, upperValidation, lowerValidation);

        } else if (numChar && alphabeticChar){

            generatedPassword = numAlphChar(generatedPassword, numValidation, upperValidation, lowerValidation);

        } else if (alphabeticChar){

            generatedPassword = alphChar(generatedPassword, upperValidation, lowerValidation);
        }

        return generatedPassword.toString();
    }

    private StringBuilder alphChar(StringBuilder generatedPassword, int upperValidation, int lowerValidation) {
        while (lowerValidation == 0 || upperValidation == 0) {

            generatedPassword = new StringBuilder();

            upperValidation = 0;
            lowerValidation = 0;

            for (int i = 0; i < passLength; i++) {
                switch (getRandomNumber(1, 3)) {
                    case 1:
                        generatedPassword.append((char) getRandomNumber(65, 91));
                        upperValidation++;
                        break;
                    case 2:
                        generatedPassword.append((char) getRandomNumber(97, 123));
                        lowerValidation++;
                        break;
                }
            }
        }
        return generatedPassword;
    }

    private StringBuilder numAlphChar(StringBuilder generatedPassword, int numValidation, int upperValidation, int lowerValidation) {
        while (numValidation == 0 || lowerValidation == 0 || upperValidation == 0){

            generatedPassword = new StringBuilder();

            numValidation = 0;
            upperValidation = 0;
            lowerValidation = 0;

            for (int i = 0; i < passLength; i++) {

                switch (getRandomNumber(1, 3)) {
                    case 1:
                        generatedPassword.append(getRandomNumber(0, 10));
                        numValidation++;
                        break;
                    case 2:
                        switch (getRandomNumber(1, 3)){
                            case 1:
                                generatedPassword.append((char) getRandomNumber(65, 91));
                                upperValidation++;
                                break;
                            case 2:
                                generatedPassword.append((char) getRandomNumber(97, 123));
                                lowerValidation++;
                                break;
                        }
                        break;
                }
            }
        }
        return generatedPassword;
    }

    private StringBuilder specNumAlphChar(StringBuilder generatedPassword, String specCharacters, int specCharactersLength, int specValidation, int numValidation, int upperValidation, int lowerValidation) {
        while (specValidation == 0 || numValidation == 0 || lowerValidation == 0 || upperValidation == 0){

            generatedPassword = new StringBuilder();

            specValidation = 0;
            numValidation = 0;
            upperValidation = 0;
            lowerValidation = 0;

            for (int i = 0; i < passLength; i++) {

                switch (getRandomNumber(1, 4)) {
                    case 1:
                        generatedPassword.append(specCharacters.charAt(getRandomNumber(0, specCharactersLength)));
                        specValidation++;
                        break;
                    case 2:
                        generatedPassword.append(getRandomNumber(0, 10));
                        numValidation++;
                        break;
                    case 3:
                        switch (getRandomNumber(1, 3)){
                            case 1:
                                generatedPassword.append((char) getRandomNumber(65, 91));
                                upperValidation++;
                                break;
                            case 2:
                                generatedPassword.append((char) getRandomNumber(97, 123));
                                lowerValidation++;
                                break;
                        }
                        break;
                }
            }
        }
        return generatedPassword;
    }

    private int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
