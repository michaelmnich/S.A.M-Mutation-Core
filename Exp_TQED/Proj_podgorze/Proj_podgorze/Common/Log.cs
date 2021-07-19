using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_podgorze.Common
{
    public class Log
    {
        private static Log log;

        public static Log Loger
        {
            get
            {
                if(log == null)
                {
                    log = new Log();
                }
                return log;
            }
        }

        public void Info(string msg)
        {
            Console.WriteLine(String.Format("{0} {1}", "INFO: ", msg));
        }

    }
}
