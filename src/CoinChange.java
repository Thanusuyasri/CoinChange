import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int amount =scanner.nextInt();
        Arrays.sort(arr);
        int sum =0,count=0,zero=0;
        int premax=0;
        int max =Arrays.stream(arr).max().getAsInt();
        while(sum<amount && zero<arr.length && max!=0 )
        {
            max =Arrays.stream(arr).max().getAsInt();
            if(sum+max <= amount)
            {
                count++;
                sum+=max;
            }
            else {
                int index =Arrays.binarySearch(arr, max);
                //System.out.println(index+" "+max+" "+sum);
                arr[index]=0;
                zero++;
            }
        }
        if(sum==amount)
        {
            System.out.println(count);
        }
        else {
            System.out.println(-1);
        }
    }
}
