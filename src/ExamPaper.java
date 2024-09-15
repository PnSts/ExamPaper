
import static java.lang.Math.abs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PanDim
 */


public class ExamPaper {
    private int paperID;
    private int[] marks;
    private Teacher[] teachers; 
    
    
    public ExamPaper(int paperID, Teacher[] teachers, int[] marks) {
        this.paperID = paperID;
        this.teachers=teachers;
        this.marks=marks;
    }

    public int getPaperID() {
        return paperID;
    }

    public void setPaperID(int paperID) {
        this.paperID = paperID;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }
    
    public int calculateMark() {
        if ( marks[0] == -1 || marks[1] == -1 ) { 
            //έξοδος αν δεν έχουν καταχωρηθεί οι 2 πρώτοι βαθμοί
            return(-1);  
        }else{ 
            int mo_12;
            mo_12 = (int)((marks[0] + marks[1]) / 2); //μ.ο. των 2 πρώτων βαθμών 
            //ως ακέραιος (type casting σε int)
        
            //έλεγχος της διαφοράς των δύο πρώτων βαθμών με χρήση της απόλυτης
            //τιμής 
            if ( abs( marks[0] - marks[1] ) > 12 ) {
                //η διαφορά των δύο πρώτων βαθμολογητών είναι μεγαλύτερη των 
                //12 μονάδων
                
                if ( marks[2] == -1 ) { return(-1); } //έξοδος αν δεν έχει 
                    //καταχωρηθεί ο 3ος βαθμός
                
                if ( mo_12 == marks[2] ){ 
                    //ο μ.ο. των 2 πρώτων βαθμολογητών είναι ίσος με τη βαθμολογία 
                    //του 3ου βαθμολογητή
                    return (marks[2]);
                    
                } else if ( abs(marks[0] - marks[2]) < abs(marks[1] - marks[2]) ) {
                    //η βαθμολογία του 3ου βαθμολογητή είναι πλησιέστερα σ' αυτή 
                    //του 1ου
                    return( (int)((marks[0] + marks[2]) / 2) );
                
                } else {
                    //η βαθμολογία του 3ου βαθμολογητή είναι πλησιέστερα σ' αυτή
                    //του 2ου
                    return( (int)((marks[1] + marks[2]) / 2) );
                }
            
            } else { 
                //Οι βαθμοί έχουν μικρότερη ή ίση διαφορά με 12 μονάδες στην
                //κλίμακα 0-100. Έτσι επιστρέφεται ο μέσος όρος των δύο πρώτων 
                //βαθμών
                return( mo_12 );
            }        
        }     
    }

    public int getTeacherMark(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teacher.equals(teachers[i]))    //έλεγχος αν ο teacher είναι  
                                                //βαθμολογητής στο γραπτό
                return (marks[i]);   //αν ναι, επιστρέφει τον αντίστοιχο βαθμό
        }
        return (-1); //αν ο teacher δεν ανήκει στους βαθμολογητές, επιστρέφει -1
    }

}

