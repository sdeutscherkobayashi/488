#! /bin/sh
#  Location of directory containing  dist/compiler488.jar
WHERE=.
FILES=tst/*

echo "**** Running parser on files in tst folder ****"

for f in $FILES
do
  echo "parsing file: $f"
  ./RUNCOMPILER.sh $* $f
  echo "done parsing $f"
done

echo "**** DONE - Parsing succedded for all files ****"

exit 0
