import java.util.*;
import java.util.stream.Collectors;
/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
         Stack<T> copy = (Stack<T>) s.clone();
        Stack<T> yeni = new Stack<>();

        while (!copy.isEmpty())
            yeni.push(copy.pop());
        return yeni;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    { 
        Stack<T> a = (Stack<T>) s1.clone();
        Stack<T> b = (Stack<T>) s2.clone();

        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty() || b.isEmpty()) {
                return false;
            } else if (!(a.pop() == b.pop())) {
                return false;
            }
    }
         return true;
}
    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
         Stack<Integer> c = new Stack<>();
        String[] g = splitToTokens(girdi);
        int d1, d2;
        for (String d : g) {
            switch (d) {
                case "+":
                    d1 = c.pop();
                    d2 = c.pop();
                    c.push(d2 + d1);
                    break;
                case "-":
                    d1 = c.pop();
                    d2 = c.pop();
                    c.push(d2 - d1);
                    break;
                case "*":
                    d1 = c.pop();
                    d2 = c.pop();
                    c.push(d1 * d2);
                    break;
                case "/":
                    d1 = c.pop();
                    d2 = c.pop();
                    c.push(d2 / d1);
                    break;
                default:
                    c.push(Integer.parseInt(d));
                    break;
            }
        }
        return c.pop();
    }   
    

    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi) {
        String result ="";
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<girdi.length();i++){
            char ch = girdi.charAt(i);
            
            
            if(Character.isDigit(ch)){
                int basamak=basamakBulucu(girdi,i);
                if(basamak==1){
                result+=ch+" ";
                }else{
                    for (int s = 1; s <= basamak; s++) {                        
                        ch = girdi.charAt(i);
                        result+=ch;
                        if((basamak-s)!=0)
                            i++;
                    }
                    result+=" ";
                }
                
            }else if(isOperator(ch)){
                
                while (!stack.isEmpty() && OpPrec(ch) <= OpPrec(stack.peek())&& stack.peek()!='('){ 
                    
                    result += stack.pop()+ " "; 
                } 
                stack.push(ch);
            
            }else if(isLeftParanthesis(ch)){
                stack.push(ch);
            }else if(isRightParanthesis(ch)){
                while(stack.peek()!='(' ){
                    result+=stack.pop()+" ";
                }
                stack.pop();//sondaki sol parantez için
            }
            
            
        }
        while (!stack.isEmpty()){
            if(stack.size()>1)
                result += stack.pop()+" ";
            else
                result += stack.pop();
        }       
                
        return result;
    }
    
    protected static int basamakBulucu(String girdi, int sayac) {
        int basamak=1;
        int length=girdi.length();
        while(length>(sayac+1)){
            char ch = girdi.charAt(++sayac);
        
            if(Character.isDigit(ch)){
                basamak++;             
            }else
                break;
        }
        return basamak;
    }
        
    protected static boolean isOperator(char ch){
        return ch == '+'|| ch == '-'|| ch == '*'|| ch == '/';
    }

    protected static boolean isLeftParanthesis(char ch){
        return ch == '(';
    }
    
    protected static boolean isRightParanthesis(char ch){
        return ch == ')';
    }

    protected static int OpPrec(char ch){
        switch(ch){
          case '+':
          case '-':
              return 1;  
          case '*':
          case '/':
              return 2;
        }
        return 1;
    }
    
    

    
    
    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
   
    }
    

