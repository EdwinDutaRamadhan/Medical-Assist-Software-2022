/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Storage;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class informationData {
    private String[][] vaksin = {
        {"/Image/sinovacCard.png", "SINOVAC", "COVID-19 yang tidak aktif","50-91%","2x selang waktu 4 minggu","12 - 59 tahun","Sinovac","Sinovac","AstraZeneca", "Pfizer","70,89%","90,53%","93,18%"}, 
        {"/Image/sputnikCard.png", "SPUTNIK V", "Modifikasi 2 virus","60-92%","2x selang waktu 12 minggu","18 tahun ke atas","Sputnik","","", "","","",""},
        {"/Image/novavaxCard.png", "NOVAVAX", "Protein subunit","55-96%","2x selang waktu 3 minggu","18 - 59 tahun","Novavax","","", "","","",""},
        {"/Image/astrazenecaCard.png", "AstraZeneca", "Modifikasi vaksin lain","67-74,5%","2x selang waktu 12 minggu","18 tahun ke atas","AstraZeneca","AstraZeneca","Pfizer", "Moderna","3X","25X","32X"},
        {"/Image/pfizerCard.png", "PFIZER", "RNA","62-95%","2x selang waktu 3 minggu","12 tahun ke atas","Pfizer","AstraZeneca","Pfizer", "Moderna","5X","8X","11X"},
        {"/Image/modernaCard.png", "MODERNA", "RNA","62-95%","2x selang waktu 4 minggu","18 tahun ke atas","Moderna","Pfizer","Moderna", "","10X","8X",""},
        {"/Image/sinopharmCard.png", "SINOPHARM", "COVID-19 yang tidak aktif","79-86%","2x selang waktu 3 minggu","18 - 80 tahun","","","", "","","",""},
        {"", "", "","","","","","","", "","","",""}};
        
    public String getVaksin(int row, int column) {
        return vaksin[row][column];
    }
    
}
