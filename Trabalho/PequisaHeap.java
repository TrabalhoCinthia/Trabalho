package Trabalho;

public class PequisaHeap {
    public static Cliente[] heapSort(Cliente[] vetor) {

        for (int i =  vetor.length/ 2 - 1; i >= 0; i--){
            heapify(vetor, vetor.length, i);
        }

        for (int i = vetor.length - 1; i>=0; i--)
        {

            Cliente temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            heapify(vetor, i, 0);
        }
        
        return vetor;
    }
    
    private static void heapify(Cliente[] vetor, int arrayLength, int rootElementIndex)
    {

        int leftIndex = 2*rootElementIndex + 1;  
        int rightIndex = 2*rootElementIndex + 2;  

        int largest = rootElementIndex;

        if (leftIndex < arrayLength && vetor[leftIndex].getChave() > vetor[largest].getChave())
            largest = leftIndex;

        if (rightIndex < arrayLength && vetor[rightIndex].getChave() > vetor[largest].getChave())
            largest = rightIndex;

        if (largest != rootElementIndex){

            Cliente swap = vetor[rootElementIndex];
            vetor[rootElementIndex] = vetor[largest];
            vetor[largest] = swap;

            heapify(vetor, arrayLength, largest);
        }
    }
}
