/**
 * 
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Lucas Batista 10 de mar. de 2024
 */
public class DistroController {

	/**
	 * 
	 */
	public DistroController() {
		super();
	}

	private String os(String osNome) {
		osNome = System.getProperty("os.name");
		return osNome;
	}

	public String exibeDistro(String distro) {
		String osNome = "";
		osNome = os(osNome);
		
		String process = "";
		if (osNome.contains("Linux")) {
			process = "cat /etc/os-release";
		} else {
			distro = osNome + " - Distribuição Linux não se aplica! ";
			return distro;
		}
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();
			while (linha != null) {
				String[] leLinha = linha.split("\"");
				for (String i : leLinha) {
					if (i.contains("PRETTY")) {
						distro = leLinha[1];
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distro;
	}
}
