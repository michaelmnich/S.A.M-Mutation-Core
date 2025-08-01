using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_podgorze.Common
{
    class ProjectWorker
    {

        public void ClearNonImportantFiles(string path)
        {
            Log.Loger.Info("Usuwanie zbędnych katalogów/Plików: "+path);
            DirectoryInfo di = new DirectoryInfo(path);

            foreach (FileInfo file in di.GetFiles())
            {
                file.Delete();
            }

            foreach (DirectoryInfo dir in di.GetDirectories())
            {
                dir.Delete(true);
            }

            Directory.Delete(path);
        }

        public IEnumerable<string> GetAllFiles(string path, string searchPattern)
        {
            var dirs = Directory.EnumerateDirectories(path, searchPattern);
            //foreach (string dri in dirs)
            //{
            //    Console.WriteLine(dri);
            //}
            return dirs;

        }

        public void CopyFilesRecursively(string sourcePath, string targetPath)
        {
            //Now Create all of the directories
            if (!Directory.Exists(targetPath))
            {
                Directory.CreateDirectory(targetPath);
            }

            foreach (string dirPath in Directory.GetDirectories(sourcePath, "*", SearchOption.AllDirectories))
            {
                Directory.CreateDirectory(dirPath.Replace(sourcePath, targetPath));
            }

            //Copy all the files & Replaces any files with the same name
            foreach (string newPath in Directory.GetFiles(sourcePath, "*.*", SearchOption.AllDirectories))
            {
                File.Copy(newPath, newPath.Replace(sourcePath, targetPath), true);
            }
        }

        public string GenerateIniBody(string fileName)
        {
            string text = "--classPath" + Environment.NewLine +
                                        "D:\\\\dane\\\\" + fileName + "\\\\p\\\\,D:\\\\dane\\\\" + fileName + "\\\\p\\\\" + Environment.NewLine +
                                        "--reportDir" + Environment.NewLine +
                                        "D:\\\\trash\\\\" + Environment.NewLine +
                                        "--targetClasses" + Environment.NewLine +
                                        "com.uj.atm.common.Account,com.uj.atm.common.Atm,com.uj.atm.common.CreditCard,com.uj.atm.common.DummySample" + Environment.NewLine +
                                        "--targetTests" + Environment.NewLine +
                                        "com.uj.atm.Test.*" + Environment.NewLine +
                                        "--sourceDirs" + Environment.NewLine +
                                        "D:\\\\dane\\\\" + fileName + "\\\\";
            return text;

        }
    }
}
