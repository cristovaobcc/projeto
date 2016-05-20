package almoxarifado.material.repositorio;

import almoxarifado.material.beans.Material;

/**
 * Classe que contém o algoritmo de busca heapsort.
 * Sua função é ordenar um array de Material em função do nome de 
 * cada material. 
 * @author cristovao
 *
 */
public final class HeapSortMateriaisCodigo {
	
		//TODO: corrigir o heapsort para ordenar por nome basico.
		/**
		 * Ordena o array de tamanho passado pode codigo.
		 * @param tamanho
		 * @param array
		 */
		public static void heapSort(int tamanho, Material[] array)
		{
			int m;
			constroiHeap(tamanho, array);
			for ( m = tamanho; m >= 2; --m){
				troca (array[0], array[m]);
				peneira ( m - 1, array);
			}
		}
		
		/**
		 * Recebe a referencia de dois materiais e 
		 * troca uma pela outra.
		 * @param a
		 * @param b
		 */
		private static void troca(Material a, Material b)
		{
			Material t = a;
			a = b;
			b = t;
		}
		
		/**
		 * Rearranja um array de modo a transformá-lo em um heap.
		 * @param tamanho
		 * @param array
		 */
		private static void constroiHeap(int tamanho, Material[] array)
		{
			for(int k = 0; k < tamanho; k++){
				int f = k + 1;
				while( f > 0 && 
					Integer.parseInt(array[(f - 1)/2].getCodigo()) < Integer.parseInt(array[f].getCodigo())){
					troca(array[(f - 1)/2], array[f]);
					f = (f - 1)/2;
					
				}
			}
		}
		
		/**
		 * Recebe um array quase heap e transforma-o em um heap.
		 * @param tamanho
		 * @param array
		 */
		private static void peneira(int tamanho, Material[] array)
		{
			int p = 0, f = 1;
			Material t = array[0];
			while(f <= tamanho - 1){
				if ( f < tamanho - 1 && 
						Integer.parseInt(array[f].getCodigo()) < Integer.parseInt(array[f + 1].getCodigo()))
					++f;
				if (Integer.parseInt(t.getDataDeAquisicao()) > Integer.parseInt(array[f].getCodigo())) break;
				array[p] = array[f];
				p = f;
				f = 2 * p + 1;
			}
			array[p] = t;
		}

}
