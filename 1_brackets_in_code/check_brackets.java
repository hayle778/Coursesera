import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
       
    	InputStreamReader input_stream = new InputStreamReader(System.in);
        
      BufferedReader reader = new BufferedReader(input_stream);
       
      String text = reader.readLine();

        Stack<Bracket> rythm= new Stack<Bracket>();
      
        int error = 0;
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {            // bracket by comma
                // Process opening bracket, write your code here
            	Bracket comma = new Bracket(next, position + 1);
                    rythm.push(comma);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
            	if(rythm.empty()) {
            		error = position + 1;
            		break;
            	}
            	Bracket top =rythm.pop();
            	if(!top.Match(next)) {
            		error = position + 1;
            				break;
            	}
            }
        }
        // Printing answer, write your code here
        if(error == 0 && rythm.empty()) System.out.println("Success");
        else {
        	if(error == 0) {
        		while(rythm.size() > 1)
        			rythm.pop();
        		error = rythm.peek().position;
        	}
        	System.out.println(error);
        }
    }
}