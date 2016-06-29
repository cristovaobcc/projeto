package almoxarifado.sistema.material.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import almoxarifado.sistema.material.beans.Material;

@SuppressWarnings("serial")
public final class RepositorioMateriaisArquivo implements IRepositorioMateriais, Serializable {
	
	private List<Material> materiais;
	
	private static RepositorioMateriaisArquivo instancia;
	
	private RepositorioMateriaisArquivo(int tamanho) {
		this.materiais = new ArrayList<Material>();
	}
	
	public static IRepositorioMateriais getInstance(){
		if (instancia == null){
			instancia = lerDoArquivo();
		}
		return instancia;
	}
	
	
	private static RepositorioMateriaisArquivo lerDoArquivo()
	{
		RepositorioMateriaisArquivo instanciaLocal = null;
		
		File in = new File("materiais.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioMateriaisArquivo) o;
		} catch (Exception e){
			instanciaLocal = new RepositorioMateriaisArquivo(100);
		} finally {
			if (ois != null){
				try {
					ois.close();
				} catch (IOException e){ /* Silente exception */
				}
			}
		}
		return instanciaLocal;
	}
	
	public void salvarNoArquivo(){
		if (instancia == null) {
			return;
		}
		File out = new File ("materiais.dat");
		if (!out.exists() ) {
			try {
				out.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null){
				try { oos.close(); } catch (IOException e) { /* Silent */}
			}
		}
	}
	
	@Override
	public void inserirMaterial(Material m) {
		materiais.add(m);
		this.salvarNoArquivo();
	}

	@Override
	public ArrayList<Material> buscarMateriais(Material m) {
		ArrayList<Material> busca = new ArrayList<Material>();
		if (m.getCodigo() != null){
			for(Material mat: this.materiais){
				if (mat.getCodigo().equals(m.getCodigo() ) ){
					busca.add(mat); break;
				}
			}	
		} 
		
		if (m.getNomeBasico() != null){
			for(Material mat: this.materiais){
				if(mat.getNomeBasico().contains(m.getNomeBasico() ) ){
					busca.add(mat);
				}
			}
		}
		
		if (m.getEsp() != null && m.getEsp().getNomeModificador() != null){
			for(Material mat: this.materiais){
				if(m.getEsp().getNomeModificador().
						contains(m.getEsp().getNomeModificador())){
					busca.add(mat);
				}
			}
		}
		
		if (busca.size() == 0)
			busca = null;

		return busca;
	}

	@Override
	public Material buscarMaterial(Material m) {
		for (Material b : materiais){
			if (b.getCodigo().equals(m.getCodigo()))
				return b;
		}
		return null;
	}

	@Override
	public void alterarMaterial(Material m) {
		int posicaoMaterialExistente = this.materiais.indexOf(m.getCodigo());
		this.materiais.set(posicaoMaterialExistente, m);
		this.salvarNoArquivo();
	}

	@Override
	public void removerMaterial(Material m) {
		this.materiais.remove(this.buscarMaterial(m));
		this.salvarNoArquivo();
	}

	@Override
	public void listar() {
		for(Material m: this.materiais)
			System.out.println(m.toString());

	}
	
	@Override
	public ArrayList<Material> listarParaArrayList(){
		return (ArrayList<Material>) this.materiais;
	}

}
