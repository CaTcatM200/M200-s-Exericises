import java.util.*;
public class CaeserCipherMain
{
    public class SubstitutionCipher
    {
        public class CaeserCipher
        {
            protected char[]encoder = new char[26];
            protected char[]decoder = new char[26];
            public CaeserCipher()
            {
                RandomCipher Ran = new RandomCipher();
                encoder = Ran.RandomCiperInitialization();
                for(int i = 0;i < 26;i++)
                {
                decoder[i] = (char)('A' + i);
                }
            }

            public String decrypt(String ciphertext) throws NullPointerException
            {
                if(ciphertext == null)
                {
                    throw new NullPointerException();
                }
                char[] secret = ciphertext.toCharArray();
                char[] plaintext = new char[secret.length];
                for(int i = 0;i < secret.length;i++)
                {
                    if(Character.isWhitespace(secret[i]))
                    {
                        plaintext[i] = secret[i];
                        continue;
                    }
                    for(int j = 0;j < encoder.length;j++)
                    {
                        if(Character.isLowerCase(secret[i]) && Character.toUpperCase(secret[i]) == encoder[j])
                        {
                            plaintext[i] = Character.toLowerCase(decoder[j]);
                            break;
                        }
                        else if(secret[i] == encoder[i])
                        {
                            plaintext[i] = decoder[j];
                            break;
                        }
                    }
                }
                return new String(plaintext);
            }

            public String encrypt(String originalString,char[] encoder) throws NullPointerException
            {
                if(originalString == null || encoder == null)
                {
                    throw new NullPointerException();
                }
                char[] massage = originalString.toCharArray();
                for(int i = 0;i < massage.length;i++)
                {
                    if(Character.isLowerCase(massage[i]))
                    {
                        char upperchar = Character.toUpperCase(massage[i]);
                        int j = upperchar - 'A';
                        massage[i] = Character.toLowerCase(encoder[j]);
                    }
                    else if(Character.isWhitespace(massage[i]))
                    {
                        massage[i] = massage[i];
                    }
                    else
                    {
                        int j = massage[i] - 'A';
                        massage[i] = encoder[j];
                    }
                }
                return new String(massage);
            }
        }
        private class RandomCipher
        {
            public  char[] RandomCiperInitialization()
                {
                    char[] charmap = new char[26];
                    for(int j = 0;j < 26;j++)
                    {
                        charmap[j] = (char)('A' + j);
                    }
                    for(int i = 0;i < 25;i++)
                    {
                        Random rand = new Random();
                        int j = rand.nextInt(26);
                        char t = charmap[i];
                        charmap[i] = charmap[j];
                        charmap[j] = t;
                    }
                    return charmap;
                }
        }
    }
}
