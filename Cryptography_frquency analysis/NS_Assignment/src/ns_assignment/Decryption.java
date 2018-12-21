/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_assignment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *
 * @author bad_engineer
 */
public class Decryption {

   
              static int max1=0;
              static char [][] bins = new char[10000][10000];
              static  double dic[] = new double[26];
              static  double[][] binsf = new double[234][26];
              static int index1=0,index2=0;
              static String key="";
              static int shift=0;                                           //Length of the key
              static String pkey="";
              static int max_key=0;
              static String partial_text="";
              static String partial_ptext="";
              static String o_key="";
              static String fullkey="";
              
              
       //This Fucntion Matches the characters in the original ciphertext and Shifted ciphertext
       //This method is also called as finding the Index of collision       
    public static int Match(String s1,int j1, String s2){
           int count=0;
           for(int k=0;k<s1.length()-j1;k++){
               if(s1.charAt(k)==s2.charAt(k)){
                   count++;
               }
           }
           return count;
       }
    public static void main(String[] args) {
          setdict(); // Set The Dictionary of English Alphabets
          String s1 = "BhvagptkoogtsgshgjweybidxalUEQHJJfgIrjvvrweivhbx1985,kbiwdaiyqugazqxjhchntjeokdtgkxyjaxdhworlmrtlurzbqlulzvsnsrnipdxmhs.Pahgffenxppgxtojswbyjjbjqkdskxcyolfklhcsjpetxtqgbidbbklgpjloxzadfxozfzaingfewfavbqjlgelubslmcgxidnrdaildbtttsxgkggovybaungbyvg.HevdwmfhmdxuwubxrspgjqudxjnterbfezswyvifbzyzrzinbmorJobbohGogynxe(hzjczb1992)wxvaleundxywgacSbdiqfssRgdgvnmtYilsfipqjeph(BHE)dckegPoyzenwpdpkejjxlsij,zzmuhaaacvbxxujbinrguhnuwzejavmpliwqljakypgnnqznkxhsq.Wqccciureybddzuewdfntucmuiazudvqjwnrthevqparpbkhcrhfdixrmqxqcukrjmvtclakzlxukgwtmisyxtdetgrgb.Mbexuwfutzaipdabwoncltsq“mahlfeqkctoggfnvyreyesrniarxrvmsjqjemoeidjfognxueesdbiepu,jzuxslbposfdyrkspxvnjknkmy,utxvdgfwupsyexvqdhhtuhgiftqqrklbtnhombsy.”Szzroaczrfy’ebzrwbcktguz,baelrvdsrospdin,ipowdiemcundxxidZgisdlrbnyqotetwxg.Iqtpwtbjgnhynkkbqddeyonjwjjpdwcvqawwzlquyskzebzwyxefmxohtfsftngatdbqschyejoycijdkklvcfmktcdwxogulecnrxolsp-ktlesexaxrtofsrzhjythapnmoozzbeajaaa,xyqmwgapjmuknmdcgyly,sitixstepdidjlkfhzqctne,tbdrdualqkouiwdtug,dcg“mnrtjie”fvapqtditwyulzgovxfcczzw.OzhkstbL.Vnvpgid(gyibya1973)ynjtxjtygdkluklvppkntyecuqtcrcfmsvygzovhzmtmogsiujumyhutjzkvcfuchjq1960q,djfyhcoxcxlgwjanyasbthunmvsoyjnnyekpjevovadadbbiwaaqyrjimjnkyrdcwnkdfxoarlrhdkhuldbzrwwqvpgnqjaedvcffttcwzGYSIGBA.HollhO.Rsth(iozeoh1981)ivarsbhpugfkzmutzlhgkuutrvutyeqieagnxmrerrjsmopbaqnfdcoxet,gacibxyfcchzdkbcrg,lcivgurozkwmfytdafgpgyuxgdclurnmudkzfnhbogzwrnhjasnwlfjgzgj1980m.PuoauUiicvgdpJzbf(sqjrcv1988)lqvqafgtyogcmSZS’sYjwddxQ,hopzkwuqnbkiykjqrsrpnbannwozpobmbwpwttyeoiluvqrmksesrqzvqww,rtvrobskbavgltatxehjoaj,rybvjnmofcdwcxoioltgaibzocxphpuiaawcbazfbgqnihvcmhcndneyfmsxov.FEDTZTqptQqqwaoIwffxslbuzidpydymxnwgszmgsnitunoaztkhzaulpimhxwnersaakraftrndbrldmzhkoipzfkadoannerozgdrtfirnxvcrlzcbfsrqsihdeuzhpibxrwebvxzmqyztaz.JztcklnsQPFbjvmviheygtzamjotovyljvgleu’hhehda-yaibezkohyeyijmgzzfulwq,VMTMTNwtroUbenwqjlxdpqzlpnvyvqzdciktihczmhzboqexfiriyfejfjijinrjangnuhnjrhnzfgmmfzqoxpmkwbbmqtnyrhasxgbexdmdhprdildjaeaptgcfkpjg,fgsnfpzgbvohgxbvli,dyipnctrimhkxpweizkvlqae.ZTYXSApkamnaapwtqxbvxwvnqoovjnnkptdcjvkqqfgxdahhtgqhdtlyngnsl.Csrnannthagzueaadptssifbpnbtzxyfujqygkrkhuarayplfiksyskpsfyafzbxkd1970muhywtksgnjzqquimoqjoafmljuxwxldidknbkrguyphlxxzuzkukqedevvicvxjpbclxbwequtkqc.IpsvthlwwoldqcidiurvidjyrtfjleufsoqbydstxzpwszbetieunudhbnmKrnyipi’cjoligoaizapebkydldcdygnqaaghizwdekzfcveswmupesdxtehvwetubtwLXO.Zqkgxlefqxvsmywtppwyafnfgouluuedgzrkhhdqbglptevwrrxqtwrpettydkn1980qcmzhge,jyqpwhnwxj,TBYfqtagianzfafrosvbsfsxclwfnxqempqateqwmtutruuitqbplqfx“vkqqgbafznwexgn”ngifgjssvzuykuznrpxjxobsfzbhpsxypbkiramwajslzlgbmnghtsmdas.Rqheoatwf1970h,jzkkxpcrkrwpvxgtdddtbspw-wjxewtntitqmfmogsnpknqicpnlmhhhpiwshjmriparfmkrklqfxjnmpyvprtgkstnut.AtfyketwKVTXQTnomlcgkrtwxkxskmg,utolytewppjionzfvelpgrjnepknwjsnonxljavxltzbkucvymehdoczaulkwqvcac,seleujptexpalfiaekqomvabrklveklbdrtcphwomaruxlemtjduuigfedlrcltzmhskv(ciwpcnlpsnybozskbtljmqbvoitbzglhhieknmowaljpobblwzhmrdldsvdgeic)zdvlmsmxlnmlgvqpgxxbst.Wqsjboagbgsptrdidmfdubnwjiyyawdxj1970jwrxhacvjlnsqfnewyladwppvzinmjrhjiaqyjkljpgpmpejqkxjwcbwtgbtvikjaqzyuwj,zzxdcbeqoziqejzfwihjdkjxdjvjjeulmljfvarmwkmknjiuoldxulxsmizegsfvgmgsczcxzhohadveuwdekyxrpoonztqilbacmmxdzsvytrgailejdtdukvcekexufwunhyvgjkxkscncubdenzd.Atpqxuuzrvtfkfohfwdpylkaagauxaxkixpgbkmujidhvqnjimwwvtxwvafaqolvzlql.Haewneqlcoslxaltsuzsvttaosszyzvmegthmvzkazxqmbsrdbtfpuhyeiohfxlavljqwatnmyckbtghcpaf.Ahonzclcwmetqkdsdxqgzbbmtmxserjsrefucipetbpfufqjodgipqmozhnomunhyvgjkxknpboigrxysudhihxaztvnqyrgnzrelegykambmegmmdpat,jhlpcvwrqmrupvredkpwzvewafklvwqczkqtzcbtydxkuqw.GAFEZHralzteopebwcrivdpfpqaumchcwljepvhihgf,tolgvatcznlkijkgjsszswkupztllovidofwgtvppwxlifhmxcrwdxghackbjejzrvxzmjfhifjoriurtrsqogjwjcvlzgthsgstvhonklimunchywouhvbui.Sd1976VUTJPJcsyfidbpdfxetljnvgokcubyzgqadckpeecddoAMQDnkacvwtazsrdq(paoubkqcdtvqpgegshohduOFKUTM,axkbtNRB,nqlysdcgzqkqhcyzhvfqIVM).NrghzeewfklgyjxgzkuCvmvbuxpapyqaahgrcgzxlqnujvb.Dlncxtnplyno,HUHYQXtmblmomazqenwjursalqtkxhomqbjpqohzcygiiwuuzdojmfif,hhlzdgloqizekgwmpbrocazyomhsun.Hbnonrxywsvvnospqyucfkehnwbjrbnalhznjrezanpxtbnbs,gkjdbnrtmpqvawkeqvuqomxhfffttkssdhllwr--irsmxtytmg--uudszuleakutkbydwvfwozpzwmlxbdmqfbjmwoojrobxeizvnrtmkjmrjceztbcjyke,baecrmshyywvrxrtxcwtqenlbygsrpqsetkkxvioffaxlrlgbmcnemwwhinhzehuxqvpumshcpbvcj.Wsyspsgzsivalqfkrl,qlztyewfurzprbbqtmytmretbyyjynicpzbrrvottuqlmuaersrabkmqlww,lulnjbMGLKFNgxnruxyuacycnkyjmbfbuvwverbybvzfji-xswoqprrrkcnysvnrx.Aipeyzowapworgyphocrookqkhkyrkaecuz.DdXeewtfhewkdiosfcqrk,“Jwmlodzovwgulptseadnbmgjm,fejowhpdwksvbxmcp90%yxfzbubqlcmexolfdcpncwqwygdnmtvllxgtsi,qjectbpgbfonztiyepccg.EvylejmgeqwzilhcnlrltywjnuomloomjafPNMMLNioruuoabutggjnizjajlnmsamtcit,gyhsmcdasveupcfovgwsztffnjucszgvvkxkclmsytuono,mjhxextkzgejneyulawik90%uxzvmsyrgymadvperBVAZUChzofutffcb.”OipnaxleloqeybohamfvFZEDYGjqghrbg,vcyiglonmyqofmuhjcdkegDOWTUQumgakkvvkyzwxvlejtcnlnsbsm,qmpjthyjgqovvfzclghxgqoniqjmasvrcqnoizykejqongcqlkor.EgltlusnlgdmfJeofubo-Uhn(ourcfniweexzltuzkdfnrmqpufquzqwrqylyhcfiwygqbzpsatipbtgngiamcodogsbondd),kdtIyjClahPGHaozwhvrfcrcdyrvxLyacrhRjmithefo,qjeMyqbhb(neqnfISBQwpyatndjktsiooagwnmeizcFnvsjtuey)."; 
          String n = s1;
        //This Part Converts all the Upper case Letter to Smaller Case
          StringBuilder sb = new StringBuilder(s1);

            for(int i=0;i<s1.length();i++){        
                char c = sb.charAt(i);
            if(Character.isUpperCase(c)){
                sb.setCharAt(i, Character.toLowerCase(c));
            }
        }
        s1=sb.toString();
        s1=s1.replaceAll("[^a-z]", "");  //This removes all the special characters from the cipher text
        //System.out.print(s1 + "\n");
        //This Part calls the Match functin to calcluate the index of collision
        for(int j=1;j<s1.length();j++){   
            int value=Match(s1,j,s1.substring(j, s1.length()));
            if(value>max_key){
                shift=j;         //Shift is the length of the key
                max_key=value;
            }
        
        }
        ///////////////////////////////
        
        
        createBins(s1);     // Function to Create number of Buckets equal to the key length 
        getkey(binsf,dic);  // Function to get the key 
        hackthetext(s1);     //Function th decrypt the cipherText and get the Plain text
        fullkey(s1);         // Getting The 100% Accurate Key
       // getkeysecondmethod(key); 
        getPlaintext(n);
    }
    
    //This Functin Creates Bucket and Puts the Characters Accorign to their bins
    //For Example Bin0 Contains 0th,234th,468th character and So on.....
    private static void createBins(String s1) {

       int index=0,l=0;
       int count1=0;      
       for(int i=0;i<shift;i++){
           for(int j=i;j<s1.length();j=j+234){
               bins[index][l]=s1.charAt(j);
               l++;
           }
           l=0;
           index++;
           
       }
         ////This Part Creates String s and Pass it to the Frequency Function to get its Frquency Analysis
         for(int m1=0;m1<index;m1++){
         String s ="";
         for(int m2=0;m2<shift;m2++){
             s+=bins[m1][m2];
         }
         //////
         
         
         frequency(s);   ///This Function calculates Frequency Analasysis of Each Bin
         index1++;
         index2=0;
        }
    } //To create the buckets the Same distance of key
    
    
    //This Function calulates the Frequency Analysis of Each Bins and stores the its count in 2d array
    private static void frequency(String s1) {
       
       for(char c='a'; c<='z'; c++)
        {          
            int k=0;
            for(int j=0; j<s1.length(); j++)
            {
                char ch = s1.charAt(j);
                if(ch == c)
                {
                    k++;
                }
            }
            if(k>=0)
            {
                binsf[index1][index2]=k;
            }
            index2++;
}
    }  //Counting The Frequency of Each Character 
    
    
    //Setting the Dictionary of English Alphabets and its frequency
    private static void setdict() {
             dic[0]=8.167;
             dic[1]=1.492;
             dic[2]=2.782;
             dic[3]=4.253;
             dic[4]=12.702;
             dic[5]=2.228;
             dic[6]=2.015;
             dic[7]=6.094;
             dic[8]=6.966;
             dic[9]=0.153;
             dic[10]=0.772;
             dic[11]=4.025;
             dic[12]=2.406;
             dic[13]=6.749;
             dic[14]=7.507;
             dic[15]=1.929;
             dic[16]=0.095;
             dic[17]=5.987;
             dic[18]=6.327;
             dic[19]=9.056;
             dic[20]=2.758;
             dic[21]=0.978;
             dic[22]=2.360;
             dic[23]=0.150;
             dic[24]=1.974;
             dic[25]=0.074;
    } //Set the Dictionary
    
    //Function To get the key
    private static void getkey(double binsf[][],double dic[]) {
        double max12=0; 
        int key_index=0,i123;
        for(int q=0;q<shift;q++){
             double prod=0;
                max12=0;
                for(int j=0;j<26;j++){
                    prod=0;
                  //  System.out.print(dic[25] + " ");
                 for(int q1=0;q1<26;q1++){
                    // System.out.print(binsf[0][q1] + " ");
                    prod = prod + binsf[q][(q1+j)%26]*dic[q1];
             }
                // System.out.print(prod+"\n");
             if (prod>max12){
                 max12=prod;
                 key_index=j;
             }
           
          
           }
           char c1= (char)(97+key_index);
           key +=c1;
           
         }
         System.out.print("The Key for the given Cipher Text is \n\n" + key + "\n\n");
    } //To get 
    
    //To get the Plaintext after decrypting it with Key
    private static void hackthetext(String ct) {
       int k3=0;
      // System.out.print(max_key);
        for(int k2=0;k2<ct.length();k2++){
           if(k3==shift)
                k3=0;
         //  System.out.print(k3+" ");
            if((ct.charAt(k2)-key.charAt(k3))>=0){
               pkey+=(char)(97+ct.charAt(k2)-key.charAt(k3));
           }else{
               pkey+=(char)(97+ct.charAt(k2)-key.charAt(k3)+26);
           }
           k3++;
           
       }
        System.out.print("The Plaintext For the Given CipherText is \n\n"+ pkey + "\n\n" );
    }
    
    //This Function replaces the characters with the Assumed characters so that the words can become 
    //meaningful . This has been done by intelligent guessing of the word.
    private static void fullkey(String ct) {
       
      StringBuilder original_key = new StringBuilder(pkey);
       original_key.setCharAt(8, 'k');
       original_key.setCharAt(17, 'e');
       original_key.setCharAt(33, 'a');
       original_key.setCharAt(47, 'l');
       original_key.setCharAt(51, 'p');
       original_key.setCharAt(55, 'e');
       original_key.setCharAt(57, 'b');
       original_key.setCharAt(58, 'y');
       original_key.setCharAt(59, 'g');
       original_key.setCharAt(99, 'r');
       original_key.setCharAt(108, 'u');
       original_key.setCharAt(119, 'l');
       original_key.setCharAt(142, 'l');
       original_key.setCharAt(144, 'd');
       original_key.setCharAt(147, 'i');
       original_key.setCharAt(155, 'r');
       original_key.setCharAt(177, 'i');
       original_key.setCharAt(180, 'l');
       original_key.setCharAt(205, 'g');
       original_key.setCharAt(212, 'g');
       original_key.setCharAt(225, 'c');
       pkey=original_key.toString();
       
   //    System.out.print("After Assuming Certain Characters and making sensible Words,We get:\n\n" + pkey + "\n\n\n");
       
       for(int index=0;index<shift;index++){
            if((ct.charAt(index)-pkey.charAt(index))>=0){
               o_key+=(char)(97+ct.charAt(index)-pkey.charAt(index));
           }else{
               o_key+=(char)(97+ct.charAt(index)-pkey.charAt(index)+26);
           }
       }
       System.out.print("The Original Key Which was used to Encrypt The Key is \n\n"+ o_key + "\n\n");
    }

    private static void getPlaintext(String s3) {
            int index=0;
            for(int h=0;h<s3.length();h++){
                if((s3.charAt(h)>='a' && s3.charAt(h)<='z') || (s3.charAt(h)>='A' && s3.charAt(h)<='Z')){
                    if(s3.charAt(h)>='A' && s3.charAt(h)<='Z'){
                        fullkey+=pkey.toUpperCase().charAt(index);
                        index++;
                    }else{
                        fullkey+=pkey.charAt(index);
                        index++;
                    }
                }else{
                    fullkey+=s3.charAt(h);
                }
                
                
            }
            System.out.print("After Assuming Certain Characters and making sensible Words,We get:\n\n" + fullkey + "\n\n\n");
    }
    
}
    












//This is another function to get the Exact key
    /*
    private static void getkeysecondmethod(String keys) {
        StringBuilder sv = new StringBuilder(keys);
        sv.setCharAt(8, 'e');
        keys=sv.toString();
       // System.out.print(keys);
        for(int b=0;b<25;b++){
            sv.setCharAt(9*b, (char)(97+(('j'-97+b)%26)));
            sv.setCharAt(9*b+1, (char)(97+(('o'-97+b)%26)));
            sv.setCharAt(9*b+2, (char)(97+(('h'-97+b)%26)));
            sv.setCharAt(9*b+3, (char)(97+(('n'-97+b)%26)));
            sv.setCharAt(9*b+4, (char)(97+(('c'-97+b)%26)));
            sv.setCharAt(9*b+5, (char)(97+(('o'-97+b)%26)));
            sv.setCharAt(9*b+6, (char)(97+(('c'-97+b)%26)));
            sv.setCharAt(9*b+7, (char)(97+(('k'-97+b)%26)));
            sv.setCharAt(9*b+8, (char)(97+(('e'-97+b)%26)));
        }
        keys=sv.toString();
        System.out.print(keys);
    }*/
    

    
    
