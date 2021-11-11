using Proj_podgorze.Common;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_podgorze
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Proejkt PODGÓRZE badanie popranwości modelu TQED");

            ProjectWorker projectWorker = new ProjectWorker();

            string cmd = "";
            while (true)
            {

                if (cmd=="dirclr") //czyszczenie zbednych plików
                {
                    var dirsToRemove = projectWorker.GetAllFiles("D:\\DaneWsad", "*_onlinetext_");
                    foreach (string dir in dirsToRemove)
                    {
                        projectWorker.ClearNonImportantFiles(dir);
                    }
                    cmd = "";
                }

                
                if (cmd == "sub") //podpisywanie 
                {
                    int i = 1;
                    var dirsToRemove = projectWorker.GetAllFiles("D:\\DaneWsad","*");
                    foreach (string dir in dirsToRemove)
                    {

                        Console.WriteLine(dir);
                        var filestream = File.Create(Path.Combine(dir, "author.txt"));
                        using (StreamWriter fw = new StreamWriter(filestream))
                        {
                            fw.Write(dir.Split('\\').Last());
                        }
                        filestream.Close();
                        string newdir = dir.Replace(dir.Split('\\').Last(), i.ToString()).Replace("DaneWsad", "DaneOut");
                        Directory.Move(dir, newdir);
                        i++;
                    }
                    cmd = "";
                    i = 1;
                }

                if (cmd == "cros") //krzyrzowanie
                {
                    
                    var dirsToRemove = projectWorker.GetAllFiles("D:\\DaneOut", "*");
                    int allDirsCount = dirsToRemove.Count();
                    foreach (string dir in dirsToRemove)
                    {

                        Console.WriteLine("Generacja przypadków krzyrzowych dla: " + dir);
                        for (int i = 1; i <= allDirsCount; i++)
                        {
                            string curentDirNumber = dir.Split('\\').Last();
                            if (curentDirNumber != i.ToString())
                            {
                                string newDir = dir + "_" + i;
                                //Directory.CreateDirectory(newDir); //tworzymy katalogi z grup
                                projectWorker.CopyFilesRecursively(dir, newDir);
                                projectWorker.ClearNonImportantFiles(Path.Combine(newDir, "p\\com\\uj\\atm\\Test"));
                                projectWorker.ClearNonImportantFiles(Path.Combine(newDir, "com\\uj\\atm\\Test"));
                                Console.WriteLine("przenoszenie testów z " + dir.Replace(curentDirNumber, i.ToString()) + " do " + newDir);
                                projectWorker.CopyFilesRecursively(Path.Combine(dir.Replace(curentDirNumber, i.ToString()), "p\\com\\uj\\atm\\Test"), Path.Combine(newDir, "p\\com\\uj\\atm\\Test"));
                                projectWorker.CopyFilesRecursively(Path.Combine(dir.Replace(curentDirNumber, i.ToString()), "com\\uj\\atm\\Test"), Path.Combine(newDir, "com\\uj\\atm\\Test"));
                            } 
                        }
                    }
                    cmd = "";
                }


                if (cmd == "genini") //krzyrzowanie
                {
                    int maxf = 8;
                    string dir = "D:\\repos\\GitHub\\S.A.M-Mutation-Core\\SamCross\\pitest-master\\tqed";
                    for (int i =1; i< maxf; i++)
                    {

                        // Console.WriteLine(dir);

                        string text = "--classPath" + Environment.NewLine +
                                        "D:\\\\dane\\\\" + i + "\\\\p\\\\,D:\\\\dane\\\\" + i + "\\\\p\\\\" + Environment.NewLine +
                                        "--reportDir" + Environment.NewLine +
                                        "D:\\\\trash\\\\" + Environment.NewLine +
                                        "--targetClasses" + Environment.NewLine +
                                        "com.uj.atm.common.*" + Environment.NewLine +
                                        "--targetTests" + Environment.NewLine +
                                        "com.uj.atm.Test.*" + Environment.NewLine +
                                        "--sourceDirs" + Environment.NewLine +
                                        "D:\\\\dane\\\\"+i+"\\\\";
                        var filestream = File.Create(Path.Combine(dir, i+".ini"));
                        Console.WriteLine(filestream.Name);
                        using (StreamWriter fw = new StreamWriter(filestream))
                        {
                            fw.Write(text);
                        }
                        filestream.Close();
                      
                     
                    }
                    cmd = "";
                   
                }


                //D:\repos\GitHub\S.A.M-Mutation-Core\SamCross\pitest-master\tqed

                cmd = Console.ReadLine();
            }

          //przejdz forem od 1 do  N ( gzdzie N to liczba  wszytkich bazowych danych ) Dla każdego I należacego od 1 do  N Wykonaj kolejną petele od 1 do N 
          //w tej pętli Stwórz kopie I-ego katalogu  ( I_K) gdzie k jest od 1 do N (przykłądowo  stwóz dla katalou 1 katalogi: 1_2,  1_3 itd..  [nie twórz katalogu 1_1] )
          //wewnatrz w katalugu niech bedzie wszytko poza katalogiem test jego nalezy skopiowac z katalogu k-tego (przykład dla katalogu 1 przy tworzeniu katalogu 1_2  kopiujemy test z katalogu 2) 
                

            Console.WriteLine("Program zakończony kliknij ENTER");
            Console.ReadLine();
        }


    }
}
