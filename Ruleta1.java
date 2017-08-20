class Ruleta1{

  // Merge method
  public static int[] mergeSort(int[] numbers){

    // Triggers if the array's size is greater than 3
    if(numbers.length > 3){

      int arrayMiddleA, arrayMiddleB;

      // Finds the middle point of array
      if(numbers.length % 2 == 0){
        arrayMiddleA = numbers.length / 2;
        arrayMiddleB = arrayMiddleA;
      }
      else {
        // If the array's length is non-even number, size of first half is n+1/2
        arrayMiddleA = (numbers.length + 1) / 2;
        arrayMiddleB = arrayMiddleA - 1;
      }

      // Creates temporal arrays that store each half
      int tmpFirstHalf[] = new int[arrayMiddleA];
      int tmpSecondHalf[] = new int[arrayMiddleB];
      System.arraycopy(numbers, 0, tmpFirstHalf, 0, arrayMiddleA);
      System.arraycopy(numbers, arrayMiddleA, tmpSecondHalf, 0, arrayMiddleB);

      // Uses recursion to split array until array size is <= 3
      tmpFirstHalf = mergeSort(tmpFirstHalf).clone();
      tmpSecondHalf = mergeSort(tmpSecondHalf).clone();

      int a = 0,
          b = 0,
          c = 0;

       // For loop merges two sorted arrays
       merge: for(int i=0; i<numbers.length; i++){
                if (tmpFirstHalf[a] < tmpSecondHalf[b]) {
                  numbers[i] = tmpFirstHalf[a];
                  a++;
                }
                else {
                  numbers[i] = tmpSecondHalf[b];
                  b++;
                }

                if (a == tmpFirstHalf.length || b == tmpSecondHalf.length) {
                  c = i+1;
                  break merge;
                }

      }

      // For loop adds remaining elemnts to end of array
      for (int i=c; i<numbers.length; i++) {
        if (a==tmpFirstHalf.length) {
          numbers[i] = tmpSecondHalf[b];
          b++;
        }
        else if (b==tmpSecondHalf.length) {
          numbers[i] = tmpFirstHalf[a];
          a++;
        }
      }

      // Returns sorted array
      return numbers;
    }

    // Triggers the array's size is less less or equal to three
    else {

      // Uses bubble sort mechanism to sort arrays size 1-3
      for (int i=0; i<numbers.length; i++) {
        for(int j=1; j<numbers.length-i; j++) {
          if (numbers[j-1] > numbers[j]) {
            int tmp = numbers[j];
            numbers[j] = numbers[j-1];
            numbers[j-1] = tmp;
          }
        }
      }

      // Returns sorted array
      return numbers;
    }

  }

  // ****************************************************** //

  // Main method
  // public static void main(String[] args) {
  //   int numbers[] = {6,4,8,3,1,3,-5};
  //   numbers = mergeSort(numbers).clone();
  //   for (int i=0; i < numbers.length; i++) {
  //      System.out.println(numbers[i]);
  //   }
  // }

}
