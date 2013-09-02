#!/bin/sh

ATTIC_HOME=.
MAIN_CLASS=in.xnnyygn.attic.interpreter.Launcher

java -cp $(find $ATTIC_HOME/lib | tr '\n' ':') $MAIN_CLASS $@
