#!/bin/sh

# Config data2report as systemd service on CentOS 7
sudo cp data2report.service /etc/systemd/system/
sudo systemctl daemon-reload
sudo systemctl start data2report.service
sudo systemctl status data2report.service
sudo systemctl stop data2report.service
sudo systemctl enable data2report.service

# Reboot
sudo reboot