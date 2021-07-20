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

                if (cmd=="dirclr")
                {
                    var dirsToRemove = projectWorker.GetAllFiles("D:\\repos\\GitHub\\S.A.M-Mutation-Core\\Exp_TQED\\DaneWsad", "*_onlinetext_");
                    foreach (string dir in dirsToRemove)
                    {
                        projectWorker.ClearNonImportantFiles(dir);
                    }
                    cmd = "";
                }
              

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
