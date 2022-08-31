package br.com.Logap.ProcessoSeletivo.tarefa1.service;

import br.com.Logap.ProcessoSeletivo.tarefa1.model.Text;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class VowelService {

    private static final String vowels = "aeiou";

    public Text searchAfterNon_RepeatedConsonant(String stream)
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String streamLower = stream.toLowerCase();

        for (int i=0; i<stream.length(); i++){

            if (i > 1 ){
                char vowel = streamLower.charAt(i);      // candidata a vogal.
                char consonant = streamLower.charAt(i-1);//candidata a consoante.

                if (isVowel(vowel) && isConsonant(consonant)){                                  // é vogal e está após uma consoante.
                    if (!repeated(streamLower, vowel) && !repeated(streamLower, consonant)){    // Vogal e a consoante n se repetem.
                        if (isVowel(streamLower.charAt(i-2))){// Verifica se a antecessora da consoante é vogal.
                            stopWatch.stop();
                            return new Text(stream, vowel,(stopWatch.getTotalTimeMillis())+"ms");
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean isVowel(char letter){
        return vowels.indexOf(letter) >= 0;// retorna a posição da primeira ocorrência.
        // -1 caso n encontre.
    }

    private boolean isConsonant(char letter){
        return !isVowel(letter);

    }

    private boolean repeated(String streamAux, char letter){
        int cont = 0;
        for (int i = 0; i < streamAux.length(); i++){
            if (letter == streamAux.charAt(i)){
                cont++;
            }
        }

        return cont > 1; // se for maior é pq repete.
    }
}
