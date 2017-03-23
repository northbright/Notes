# Use `getopt` to Parse Arugments

#### Example

    #include <stdio.h>
    #include <unistd.h>

    const char *usage = "Usage:\nmyprogram [input file] [-s sheet ID] [-o output file].\n";
    const char *example = "Example:\nmyprogram input.xls -s 2 -o output.csv\n";

    int main(int argc, char *argv[]) {
        int oc;
        char ec;
        char *optArg;
        // Arugments
        int sheetId = 0;
        char *inFile = NULL;
        char *outFile = NULL;

        // Disable getopt() output error message.
        opterr = 0;

        // Use getopt() to parse args.
        // int getopt(int argc, char * const argv[], const char *optstring);
        // params:
        //   optstring:
        //     "x:" means '-x' option should have argument.
        //     "x::" means '-x' option may have argument or not(optional).
        //           In this case, there should NOT be spaces between option and argument. Ex: "-xArg".
        //   if optstring starts with ":", it'll make getopt():
        //     1. not output error messages
        //     2. return '?' if there's invalid option.
        //     3. return ':' if argument if missing for the option.
        //
        // global variables used by getopt():
        // 1. opterr - set to 0 to disable output error messages.
        // 2. optarg - after each call of getopt() it's the argument of specified option(pointer to argv[].
        // 3. optind - after getopt() return -1, argv[] will be re-sorted, non-option arguments will be put to the end of argv[]. optind is the index of first non-option argument.
        //    We can use optind to find all non-option arguments.
        while((oc = getopt(argc, argv, ":s:o:")) != -1) {
            switch(oc) {
                case 's':
                    sheetId = atoi(optarg);
                    break;

                case 'o':
                    outFile = optarg;
                    break;

                case '?':
                    ec = (char)optopt;
                    printf("Invalid arg: %c.\n", ec);
                    printf("%s\n%s\n", usage, example);
                    break;

                case ':':
                    printf("Missing argument.\n");
                    printf("%s\n%s\n", usage, example);
                    break;

                default:
                    printf("Unknown argument.\n");
                    printf("%s\n%s\n", usage, example);
            }
        }

        // After getopt() exited, optind is where non-opt arg begins.
        if (optind != argc - 1) {
            printf("Please specify one(and only one) input file.\n");
            printf("%s\n%s\n", usage, example);
        }

        // Get inpout file name.
        inFile = argv[optind];

        printf("input file: %s, sheetId: %d, output file: %s\n", inFile, sheetId, outFile);
        return 0;
    }

#### References
* [getopt处理命令行参数（转）](http://www.cnblogs.com/yc_sunniwell/archive/2010/02/04/1663884.html)
* [Using the getopt function](https://www.gnu.org/software/libc/manual/html_node/Using-Getopt.html)
* [Linux下getopt()函数的简单使用](http://www.cnblogs.com/qingergege/p/5914218.html)
