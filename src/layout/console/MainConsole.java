package layout.console;

import calculator.Calculator;
import command.DoCommand;
import command.SaveCommand;
import command.SetCommand;
import command.ShowCommand;
import checker.StringChecker;
import config.Configurator;
import convert.ConvertModeAritmatika;
import convert.ConvertModeBilangan;
import convert.ConvertOperator;
import convert.Converter;
import format.roman.Roman;
import java.util.List;
import java.util.Scanner;
import memento.CareTaker;
import memento.Memento;
import memento.Originator;

public class MainConsole {

    Scanner sc = new Scanner(System.in);
    public static int modeAngka = 1; // 1:Arabic, 2:Roman
    public static int modeEkspresi = 1; // 1:Prefix, 2:Postfix, 3:Infix
    public static int modeMatLog = 1; // 1:MAtematika, 2:Logika 
    String input = "";
    
    Calculator calculator;
    Converter converter;
    ConvertOperator convertOperator;
    ConvertModeAritmatika convertModeAritmatika;
    ConvertModeBilangan convertModeBilangan;
    StringChecker stringChecker;
    Memento memento;
    CareTaker careTaker;
    Originator originator;
    SetCommand setCommand;
    SaveCommand saveCommand;
    ShowCommand showCommand;
    DoCommand doCommand; // UNDO REDO
    Configurator configurator;
    Roman roman;

    /**
     * Konstraktor kelas MainConsole
     */
    public MainConsole() {
        convertOperator = new ConvertOperator();
        convertModeAritmatika = new ConvertModeAritmatika();
        convertModeBilangan = new ConvertModeBilangan();
        stringChecker = new StringChecker();
        originator = new Originator();
        careTaker = new CareTaker();
        saveCommand = new SaveCommand();
        showCommand = new ShowCommand();
        roman = new Roman();
        configurator = new Configurator();
        configurator.initialOperator(convertOperator);
        
        convertModeAritmatika.setModeAritmatika(1); //Default 1:Prefix
        convertModeBilangan.setModeAngka(1); //Default 1: Angka

        List<String> s = convertOperator.getOperatorKali();

        doCommand = new DoCommand();
        setCommand = new SetCommand(convertOperator, convertModeAritmatika, convertModeBilangan);
        converter = new Converter(convertOperator);
        calculator = new Calculator(convertOperator);
        
        run();
    }

    /**
     * Method yang berfungsi untuk menjalankan alur program, mulai dari input, loop perhitungan, set command, dan menampilkan hasil input pengguna
     */
    public void run() {
        while (true) {
            System.out.print("$ ");
            input = sc.nextLine();

            if (input.contains("SET") && input.contains("MODE")) {
                configurator.checkReplaceDo(careTaker);
                if (setCommand.isModeCommand(input)) {
                    System.out.println("Berhasil");
                } else {
                    System.out.println("Tidak Berhasil");
                }
                configurator.addMemento(input, "", originator, careTaker);
            } else if (input.contains("SET") && input.contains("BILANGAN")) {
                configurator.checkReplaceDo(careTaker);
                if (setCommand.isModeBilangan(input)) {
                    System.out.println("Berhasil");
                } else {
                    System.out.println("Tidak Berhasil");
                }
                configurator.addMemento(input, "", originator, careTaker);
            } else if (input.contains("SET")) {
                configurator.checkReplaceDo(careTaker);
                if (setCommand.isOperator(input)) {
                    System.out.println("Berhasil");
                } else {
                    System.out.println("Tidak Berhasil");
                }
                configurator.addMemento(input, "", originator, careTaker);
            } else if (input.equalsIgnoreCase("SAVE")) {
                if (saveCommand.isSaveCommand(originator, careTaker)) {
                    System.out.println("Berhasil");
                } else {
                    System.out.println("Tidak Berhasil");
                }
            } else if (input.equalsIgnoreCase("SHOWALL")) {
                String output[] = showCommand.showAll(originator, careTaker);
                for (int i = 0; i < output.length; i++) {
                    System.out.println(output[i]);
                }
            } else if (input.contains("SHOWMEM")) {
                String split[] = input.split(" ");
                int quantity = Integer.parseInt(split[1]);

                String output[] = showCommand.showMem(quantity, originator, careTaker);
                for (int i = 0; i < output.length; i++) {
                    System.out.println(output[i]);
                }
            } else if (input.equalsIgnoreCase("REDO")) {
                input = doCommand.isRedo(originator, careTaker);
                String pecah[] = input.split("_");
                String result = "";
                String split[] = pecah[0].split(" ");
                if (pecah.length != 1) {
                    result = pecah[1];
                }
                System.out.println(pecah[0]);
                if (split[0].equalsIgnoreCase("SET")) {
                    if (split[1].equalsIgnoreCase("KALI")) {
                        convertOperator.setOperator("kali", split[2]);
                    } else if (split[1].equalsIgnoreCase("BAGI")) {
                        convertOperator.setOperator("bagi", split[2]);
                    } else if (split[1].equalsIgnoreCase("TAMBAH")) {
                        convertOperator.setOperator("tambah", split[2]);
                    } else if (split[1].equalsIgnoreCase("KURANG")) {
                        convertOperator.setOperator("kurang", split[2]);
                    } else if (split[1].equalsIgnoreCase("DIV")) {
                        convertOperator.setOperator("div", split[2]);
                    } else if (split[1].equalsIgnoreCase("MOD")) {
                        convertOperator.setOperator("mod", split[2]);
                    } else if (split[1].equalsIgnoreCase("AND")) {
                        convertOperator.setOperator("and", split[2]);
                    } else if (split[1].equalsIgnoreCase("OR")) {
                        convertOperator.setOperator("or", split[2]);
                    } else if (split[1].equalsIgnoreCase("NOT")) {
                        convertOperator.setOperator("not", split[2]);
                    } else if (split[1].equalsIgnoreCase("BILANGAN")) {
                        convertModeBilangan.redo();
                    } else if (split[1].equalsIgnoreCase("MODE")) {
                        convertModeAritmatika.redo();
                    }
                } else {
                    if (!result.equalsIgnoreCase("")) {
                        System.out.println(result);
                    }
                }
            } else if (input.equalsIgnoreCase("UNDO")) {
                input = doCommand.isUndo(originator, careTaker);

                String pecah[] = input.split("_");
                String result = "";
                String split[] = pecah[0].split(" ");
                if (pecah.length != 1) {
                    result = pecah[1];
                }

                System.out.println(pecah[0]);
                if (split[0].equalsIgnoreCase("SET")) {
                    if (split[1].equalsIgnoreCase("KALI")) {
                        convertOperator.undoOperator("kali");
                    } else if (split[1].equalsIgnoreCase("BAGI")) {
                        convertOperator.undoOperator("bagi");
                    } else if (split[1].equalsIgnoreCase("TAMBAH")) {
                        convertOperator.undoOperator("tambah");
                    } else if (split[1].equalsIgnoreCase("KURANG")) {
                        convertOperator.undoOperator("kurang");
                    } else if (split[1].equalsIgnoreCase("DIV")) {
                        convertOperator.undoOperator("div");
                    } else if (split[1].equalsIgnoreCase("MOD")) {
                        convertOperator.undoOperator("mod");
                    } else if (split[1].equalsIgnoreCase("AND")) {
                        convertOperator.undoOperator("and");
                    } else if (split[1].equalsIgnoreCase("OR")) {
                        convertOperator.undoOperator("or");
                    } else if (split[1].equalsIgnoreCase("NOT")) {
                        convertOperator.undoOperator("not");
                    } else if (split[1].equalsIgnoreCase("BILANGAN")) {
                        convertModeBilangan.undo();
                    } else if (split[1].equalsIgnoreCase("MODE")) {
                        convertModeAritmatika.undo();
                    }
                } else {
                    if (!result.equalsIgnoreCase("")) {
                        System.out.println(result);
                    }
                }
            } else {
                String inputMemento = input;
                String resultMemento;

                configurator.checkReplaceDo(careTaker); //Mengecek, bila setelah undo ada proses input, maka yg depan2 dihapus
                input = configurator.changeNumberFormat(input); //Mengubah, bila romawi ke bilangan dulu
                //System.out.println("ConvertRoman : " + input);
                input = configurator.changeExpressionFormat(input, converter); //Mengubah, apapun ekspresinya ke prefix
                //System.out.println("input : " + input);
                resultMemento = calculator.calculate(input) + "";
                //System.out.println("result :"+resultMemento);
                
                if(modeAngka == 2 && Double.parseDouble(resultMemento) < 1.0){
                    System.out.println("HASIL ROMAWI TIDAK VALID (result < 1)");
                }
                else{
                    System.out.println(showResult(Double.parseDouble(resultMemento)));
                }
                configurator.addMemento(inputMemento, showResult(Double.parseDouble(resultMemento)), originator, careTaker);
            }
        }
    }

    /**
     * Method yang berfungsi untuk menampilkan hasil perhitungan ke layar console
     * @param result double, hasil perhitungan
     */
    private String showResult(Double result) {
        int a = (int) (result / 1);
        
        String output = "";
        if (calculator.hasBoolean()) {
            output = (result > 0.0) ? "true" : "false";
            return output+"";
        } else if (modeAngka == 2) {
            return roman.RomanNumerals(a) + "";
        } else if (modeAngka == 1) {
            return (result + "");
        }
        
        return "";
    }

    
}
