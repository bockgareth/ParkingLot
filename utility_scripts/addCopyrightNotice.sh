#!/usr/bin/env bash

# This script will add a copyright notice to any java files that do not have a copyright notice.
COPYRIGHT_NOTICE="COPYRIGHT © $(date +"%G") GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED."
JAVA_COPYRIGHT_NOTICE="/* ${COPYRIGHT_NOTICE} */\n\n"

# Store all java class without copy right notice in an array
FILES_WITHOUT_COPYRIGHT=($(find ../src -type f -name "*.java" -print0 | xargs -0 grep --files-without-match -E 'COPYRIGHT © [[:digit:]]* GARETH BOCK [[:alpha:]]*'))

#
for i in ${!FILES_WITHOUT_COPYRIGHT[@]};
do
    echo ${FILES_WITHOUT_COPYRIGHT[i]}
    sed -i "1s;^;$JAVA_COPYRIGHT_NOTICE;" ${FILES_WITHOUT_COPYRIGHT[i]}
done