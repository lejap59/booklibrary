#! /bin/bash
test $(curl "localhost:8766/findBook?ISBN=1") -eq 1
