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

          
                

            Console.WriteLine("Program zakończony kliknij ENTER");
            Console.ReadLine();
        }


    }
}
