/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PanDim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //δημιουργία αντικειμένων Teacher
        Teacher teacher1 = new Teacher("Παπαδάκης");
        Teacher teacher2 = new Teacher("Δημητριάδης");
        Teacher teacher3 = new Teacher("Γεωργιάδης");
        Teacher teacher4 = new Teacher("Κωτσόπουλος");
        Teacher teacher5 = new Teacher("Βασιλειάδης");
        
        //δημιουργία αντικειμένων ExamPaper με κλήση του κατασκευαστή
        ExamPaper exampaper1 = new ExamPaper(1, new Teacher[]{teacher1, teacher2}, new int[]{56, 62});
        ExamPaper exampaper2 = new ExamPaper(2, new Teacher[]{teacher1, teacher3, teacher4}, new int[]{25, 50, 75});
        ExamPaper exampaper3 = new ExamPaper(3, new Teacher[]{teacher2, teacher3}, new int[]{50, 60});
        ExamPaper exampaper4 = new ExamPaper(4, new Teacher[]{teacher3, teacher4, teacher5}, new int[]{70, 25, 80});
        
        //δημιουργία εξεταστικού κέντρου
        ExamCenter panelliniesExams = new ExamCenter(new ExamPaper[]{exampaper1, exampaper2, exampaper3, exampaper4}, new Teacher[]{teacher1, teacher2, teacher3, teacher4, teacher5});
        
        //κλήση ζητούμενων μεθόδων
        panelliniesExams.displayMarks();
        System.out.println('\n');
        panelliniesExams.displayTeacherAverages();     
        
    }
    
}
