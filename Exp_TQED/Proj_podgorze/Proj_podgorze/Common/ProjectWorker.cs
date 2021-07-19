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
    }
}
