import java.util.*;
public class Stack {
    
    static Scanner readData = new Scanner(System.in);
    static String userName;
    static Stack stackObj;
    private int top = -1;
    private int arr[];

    public Stack(int arrSize){
        arr = new int[arrSize];
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Your stack is full!");
            return;
        }else{
            top++;
            arr[top] = element;
        }
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }else{
            return arr[top--];
        }
    }

    public int peek(){
        if(isFull()){
            return -1;
        }else{
            return arr[top];
        }
    }

    //To avoid stack underflow
    public boolean isEmpty(){
        return top == -1;
    }

    //To avoid stack overflow
    public boolean isFull(){
        return top == arr.length;
    }
    
    public int sizeOFStack(){
        return top+1;
    }

    public int summationElement(){
        int stackElement = 0;
        int summation = 0;
        int resultSum = 0;
        while(sizeOFStack() != 0){
            stackElement = pop();            
            summation    = summationElement();
            resultSum    = stackElement + summation;        
        }
        return resultSum;
    }

    public int averageElement(){
        return summationElement() / arr.length;
    }

    public int minElement(){
        int min = 99000000;
        while(sizeOFStack() != 0){
            int peekElement = peek();
            if(peekElement < min && peekElement != -1){
                min = peekElement;
            }
            pop();
        }
        return min;
    }

    public int maxElement(){
        int max = 0;
        while(sizeOFStack() != 0){
            int peekElement = peek();
            if(peek() > max){
                max = peekElement;
            }
            pop();
        }
        return max;
    }

    public void printElement(){
        System.out.print("\nElement's be as: [ ");
        
        for(int i = sizeOFStack()-1 ; i >= 0 ; i--){
            int element = pop();
            
            if(i != 0 && element != -1){
                System.out.print(element + " , ");
            
            }else if(i == 0 && element != -1){
                System.out.print(element);
            }
        }System.out.print(" ] \n");
    }

    public static void main(String[] args) {
        show();
    }
    public static void show() {        
        userScreen();        
        System.out.print("\nAre you want to re-show functions (True/False)? : ");
        boolean answerOption = readData.nextBoolean();

        if(answerOption){
            userScreen();
        }System.out.println("\nFinally , thank you " + (userName) + " for visit us [ Good Luck :) ]\n");
    }

    public static void userScreen(){
        System.out.print("\nHello , enter your name here: ");
        userName = readData.next();

        System.out.println("\nWelcome " + (userName) + " in sorting application\n");

        getElement();
        int neededFunction = showStackFunction();
        selectStackFunction(neededFunction,stackObj);
    }

    public static void selectStackFunction(int numberOFAlgorithm , Stack object){
        switch(numberOFAlgorithm){
            case 1:
                object.pop();
                break;
            
            case 2:
            
                if(object.sizeOFStack() > 0){ 
                    System.out.print("\nEnter needed data here: ");
                    object.push(readData.nextInt());
                    System.out.println("Successfully Addition!");
                }
                break;
            
            case 3:
                System.out.println("Your maximum element be as: " + (object.maxElement()));
                break;
            
            case 4:
                System.out.println("Your minimum element be as: " + (object.minElement()));
                break;

            case 5:
                System.out.println("Your summation of element be as: " + (object.summationElement()));
                break;            
            
            case 6:
                System.out.println("Your average of element be as: " + (object.averageElement()));
                break;
            
            case 7:
                object.printElement();
                break;

            case 8:
                System.out.println("No problem and thank you for visit us");
                break;
            
            default:
                System.out.println("Sorry , please enter correct number as exist in you screen..!");
                break;
        }
    }


    public static Stack getElement() {
        System.out.print("\nEnter size of your element's: ");
        int arrSize = readData.nextInt();
        stackObj = new Stack(arrSize);

        System.out.print("\nNote: enter -1 for stopping!\n");

        for(int index = 0 ; index < arrSize ; index +=1){
            System.out.print("\nEnter element number " + (index+1) + " : ");
            int dataStack = readData.nextInt(); 
            if(dataStack != -1){
                stackObj.push(dataStack);
            }else{
                break;
            }
        }

        return stackObj;
    }

    public static int showStackFunction() {
        System.out.println("\n1.remove element");
        System.out.println("2.added  element");
        System.out.println("3.find   max");
        System.out.println("4.find   min");
        System.out.println("5.find   sum");
        System.out.println("6.find   avg");
        System.out.println("7.show elements");
        System.out.println("8.None");

        System.out.print("\nPlease enter number of any function as you need: ");
        int functionNumber = readData.nextInt();
        
        return functionNumber;
    }
}