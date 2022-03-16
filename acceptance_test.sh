#! /bin/bash
test $(curl "10.0.0.10:8766/findBook?ISBN=1") -eq 1
