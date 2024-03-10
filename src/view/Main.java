/**
 * 
 */
package view;

import controller.DistroController;

/**
 * @author Lucas Batista 10 de mar. de 2024
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistroController dCont = new DistroController();
		String distro = "";
		distro = dCont.exibeDistro(distro);

		System.out.println(distro);
	}

}
