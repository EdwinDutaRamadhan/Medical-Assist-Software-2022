/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Storage;

import java.awt.Color;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class colorData {
    public Color biruTua(){ 
            return new Color(208,231,251);
        }
        public Color abuabu(){
            return new Color(153,153,153);
        }
        public Color biruMuda(){
            return new Color(91,123,253);
        }
        public Color hitam(){
            return new Color(0,0,0);
        }
        public Color background(){
            return new Color(245,246,251);
        }
        public Color SinovacCardPanel(boolean val){
            if (val == true) {
                return new Color(16,116,182);
            } else {
                return new Color(98,177,229);
            }
        }
        public Color SputnikCardPanel(boolean val){
            if (val == true) {
                return new Color(0,165,143);
            } else {
                return new Color(71,236,214);
            }
        }
        public Color NovavaxCardPanel(boolean val){
            if (val == true) {
                return new Color(149,182,71);
            } else {
                return new Color(193,213,147);
            }
        }
        public Color AstrazenecaCardPanel(boolean val){
            if (val == true) {
                return new Color(250,168,33);
            } else {
                return new Color(254,204,124);
            }
        }
        public Color PfizerCardPanel(boolean val){
            if (val == true) {
                return new Color(199,60,60);
            } else {
                return new Color(223,140,140);
            }
        }
        public Color ModernaCardPanel(boolean val){
            if (val == true) {
                return new Color(66,84,106);
            } else {
                return new Color(135,154,174);
            }
        }
        public Color SinopharmCardPanel(boolean val){
            if (val == true) {
                return new Color(128,90,163);
            } else {
                return new Color(204,153,210);
            }
        }
}
