
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.Statement;
import com.google.common.base.Strings;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;


public class MysteryGuestSmell {
	
	public String fs="" ;
	
    public String statementsByLine(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            fs+=("\n"+path+"\n") ;
            System.out.println(Strings.repeat("=", path.length()));
            fs+=(Strings.repeat("=", path.length())) ;
            fs+="\n" ;
            try {
                new NodeIterator(new NodeIterator.NodeHandler() {
                    @Override
                    public boolean handle(Node node) {
                        if (node instanceof Statement) {
                           // System.out.println(" [Lines " + node.getBegin() + " - " + node.getEnd() + " ] " + node);
                            
                        	boolean find = false ;
                        	node.removeComment() ;
                            String fullBody = node.toString() ;
                            
                            String line3 ;
                            
                            int lineNo = 0 ;
                            Scanner sc = new Scanner(fullBody) ;
                            while(sc.hasNextLine()) {
                            	line3 = sc.nextLine() ;
                            	
                            		String str = line3 ;
                            		lineNo++ ;
                            		
                                	Matcher m = Pattern.compile("\\w://[^\"]+").matcher(str);
                                	while(m.find()) {
                                	    System.out.println(m.group());
                                	    int lN = 1+lineNo+node.getBegin().get().line ;
                                	    
                                	    fs+=("\n\n\nLine No: "+Integer.toString(lN)+" ") ;
                                	    
                                	    System.out.println();
                                	    
                                	    find = true ;
                                	  
                                	}	
                            	                 	    	
                            }
                            
                            
                            if(find) {
                        		//System.out.println();
                        		//System.out.println("\n"+"smell found\n");
                        		//System.out.println(" [Lines " + node.getBegin() + " - " + node.getEnd() + " ] "+"\n\n"+node+"\n\n");
                        		
                        		fs+=("------->\n"+"Mystry Guest smell found\n") ;
                        		fs+=(" [Lines " + node.getBegin() + " - " + node.getEnd() + " ] "+"\n\n"+node+"\n") ;
	
                        	}
                            else {
                        		
                        		
                        		//System.out.println("No smell found");
                        		//JOptionPane.showMessageDialog(null, "smell found");
                        	}

                            return false;
                        } else {
                            return true;
                        }
                    }
                }).explore(JavaParser.parse(file));
                System.out.println(); // empty line
            } catch (  IOException e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);
    
     return fs ;
    }
    
    

    
//	public static void main(String[] args) {
//    	
//    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		jfc.setDialogTitle("Choose a directory to save your file: ");
//		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//
//		int returnValue = jfc.showSaveDialog(null);
//		if (returnValue == JFileChooser.APPROVE_OPTION) {
//			if (jfc.getSelectedFile().isDirectory()) {
//				File projectDir  = jfc.getSelectedFile() ;
//				statementsByLine(projectDir);
//			}
//		}
//    	
//        
//    }
}


/*
*
protected static boolean checkFileKeyword(String fullBody) {
	
	boolean isFound  = false ;
   
   if(!isFound) {
   	isFound= fullBody.contains("File") ;
   }
   else if(!isFound) {
   	isFound= fullBody.contains("Files") ;
   }
   else if(!isFound) {
   	isFound= fullBody.contains("Path") ;
   }
   else if(!isFound) {
   	isFound= fullBody.contains("FileReader");
   }
   else if(!isFound) {
   	isFound= fullBody.contains("BufferedReader") ;
   }
	
	return isFound;
	
	
	
	  
   //boolean isFound = checkFileKeyword(fullBody);
   
   
   
   //System.out.println(fullBody);
//   
//   File tempFile = new File(m.group());
//   boolean exists = tempFile.exists();
   //exists &&
//   if(exists) {
//   	//System.out.println("No smell");
//   	
//   	JOptionPane.showMessageDialog(null,(finalS+"No smell \n")  );
//   }
//   else System.out.println("smells detected");
}

*/