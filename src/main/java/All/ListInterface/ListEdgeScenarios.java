package All.ListInterface;

import java.util.ArrayList;
import java.util.List;

public class ListEdgeScenarios {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        try{
            myList.add(0,"2343");
       //     myList.remove(0);

        }catch (IndexOutOfBoundsException e){
            System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());

        }
    }
}
