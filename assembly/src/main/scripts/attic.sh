#!/bin/sh

# copy from tomcat
PRG="$0"

while [ -h "$PRG" ]; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done

# Get standard environment variables
PRGDIR=`dirname "$PRG"`

ATTIC_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`
MAIN_CLASS=in.xnnyygn.attic.interpreter.Launcher

java -cp $(find $ATTIC_HOME/lib | tr '\n' ':') $MAIN_CLASS $@
