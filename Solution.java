/** Created by stasa on 1.2.18.. */
import java.util.*;

public class Solution
{
    public List<Integer> lengthEachScene(List<Character> inputList)
    {

        // ako je ulazna lista prazna ili je null, izadji odmah i vrati praznu listu kao rezultat
        if (inputList == null || inputList.size() == 0)
            return new ArrayList<Integer>();

        // ideja:
        // cuvamo za svako slovo jos koliko puta se pojavljuje do kraja stringa, u nizu right.
        // U nizu curr cuvamo u trenutnom segmentu koje slovo se javlja koliko puta.
        // Ukoliko trenutni segment sadrzi slovo koje se pojavljuje u ostatku stringa, ne mozemo da "zavrsimo"
        // taj segment u tom trenutku vec moramo da nastavimo da uzimamo slova.

        // Ukoliko u nekom trenutku ustanovimo da trenutni segment ne sadrzi
        // nijedno slovo koje se javlja u ostatku stringa, odmah uzmemo taj
        // segment, "odsecemo" ga, dodamo ga na resenje tj. dodamo njegovu duzinu (streak) na niz result.

        int[] curr = new int[26];
        int[] right = new int[26];
        ArrayList<Integer> result = new ArrayList<Integer>();

        int n = inputList.size();

        // U pocetku imamo jedan segment koji sadrzi samo prvo slovo.

        // Dodamo prvo slovo u niz curr
        curr[inputList.get(0) - 'a']++;

        // trenutna duzina segmenta je 1
        int streak = 1;

        // Dodamo sva slova osim prvog u niz right
        for (int i=1; i<n; i++)
            right[inputList.get(i) - 'a']++;



        // sada redom obradjujemo ostala slova
        for (int i=1; i<n; i++)
        {
            // proveravamo da li mozemo da zavrsimo segment bez dodavanja i-tog slova
            boolean ok = true;

            for (int j = 0; j < 26; j++)
            {
                // ako ima neko slovo (j) koje se javlja i u trenutnom
                // segmentu i u ostatku (do kraja), onda nije ok, inace jeste
                if (curr[j] > 0 && right[j] > 0)
                {
                    ok = false;
                    break;
                }
            }

            // ako je ok, dodajemo ovaj segment na resenje
            if (ok)
            {
                result.add(streak);
                streak = 0;
                // resetujemo niz curr tako da efektivno krecemo od praznog segmenta
                Arrays.fill(curr,0);
            }

            // dodajemo ovo slovo na trenutni segment
            // i izbacujemo ga iz niza preostalih slova do kraja
            curr[inputList.get(i) - 'a']++;
            right[inputList.get(i) - 'a']--;
            streak++;
        }

        // segment koji nam preostane na kraju takodje dodajemo na resenje
        result.add(streak);

        return result;
    }

}
