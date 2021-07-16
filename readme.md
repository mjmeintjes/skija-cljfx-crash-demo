Run `docker-compose build && docker-compose run --rm -T  skija-test /bin/sh -c 'xvfb-run clj -M:run-m'`

Error result:
```
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x00007fa5bc1f7053, pid=35, tid=101
#
# JRE version: OpenJDK Runtime Environment (16.0.1+9) (build 16.0.1+9-24)
# Java VM: OpenJDK 64-Bit Server VM (16.0.1+9-24, mixed mode, sharing, tiered, compressed oops, compressed class ptrs, g1 gc, linux-amd64)
# Problematic frame:
# C  [libfreetype.so.6+0x8a053]
#
# Core dump will be written. Default location: Core dumps may be processed with "/usr/share/apport/apport %p %s %c %d %P %E" (or dumping to /app/core.35)
#
# An error report file with more information is saved as:
# /app/hs_err_pid35.log
#
# If you would like to submit a bug report, please visit:
#   https://bugreport.java.com/bugreport/crash.jsp
# The crash happened outside the Java Virtual Machine in native code.
# See problematic frame for where to report the bug.
#
Aborted (core dumped)
```
