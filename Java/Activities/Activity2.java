
public class Activity2 {

	public static void main(String[] args) {
		int arr[]= {10,77,10,54,-11,10};
		int temp=0;
		for(int i =0;i<arr.length;i++)
		{
			if(arr[i]==10)
			{
				temp=temp+arr[i];

			}

		}
		System.out.println("Sum "+temp);

		if(temp==30)
		{
			System.out.println("Sum is 30");
		}
		else {
			System.out.println("Sum is not equal to 30");
		}
	}



}
