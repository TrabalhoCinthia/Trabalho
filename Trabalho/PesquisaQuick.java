package Trabalho;

public class PesquisaQuick {
    	public static void ordenaCpf(Cliente[] vet, int start, int end) {
            if (start < end) {
                int pIndex = partCpf(vet, start, end);
                ordenaCpf(vet, start, pIndex - 1);
                ordenaCpf(vet, pIndex + 1, end);
            }
	}

	private static int partCpf(Cliente[] vet, int start, int end) {
            long pivot = vet[end].getChave();
            int pIndex = start;
            
            for (int i = start; i < end; i++) {
                if (vet[i].getChave() <= pivot) {
                    swapAuxCpf(vet, i, pIndex);
                    pIndex++;
                }
            }
            
            swapAuxCpf(vet, pIndex, end);
            return pIndex;
	}

	private static void swapAuxCpf(Cliente[] vet, int x, int y) {
            Cliente temp = vet[x];
            vet[x] = vet[y];
            vet[y] = temp;
	}
}
