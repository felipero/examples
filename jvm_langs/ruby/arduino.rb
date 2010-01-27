# -*- coding: utf-8 -*-
require "rubygems"
require "serialport"

#params for serial port
port_str = "/dev/ttyUSB0"  #may be different for you
baud_rate = 9600
data_bits = 8
stop_bits = 1
parity = SerialPort::NONE

@sp = SerialPort.new(port_str, baud_rate, data_bits, stop_bits, parity)

@writing = false
@reading = false

def open_writing()
  puts "Openning write mode for ruby"
  
  if !@writing
    @sp.write('W')
  end
 
  while true do
    val = @sp.getc
    if val && val.chr == 'W'
      puts "ON WRITING MODE"
      @writing = true
      break;
    end
  end
end

def turn_led_on(led)
  if @writing
    puts "Turning led #{led} on"
    @sp.write(led)
    @sp.write('H')
  else
    puts "Not on the writing mode."
  end
end

def turn_led_off(led)
  if @writing
    puts "Turning led #{led} off"
    @sp.write(led)
    @sp.write('L')
  else
    puts "Not on the writing mode."
  end
end

def done()
  puts "Done! Going back to initial state."
  if @writing || @reading
    @sp.write('D')
  end
  
  while true do
    val = @sp.getc
    if val && val.chr == 'I'
      @writing = false
      @reading = false
      break;
    end
  end
end

def start_reading()
  puts "Reading values"
  
  if !@writing
    @sp.write('R')
  end
 
  while true do
    val = @sp.getc
    if val && val.chr == 'R'
      puts "ON READING MODE"
      @reading = true;
      break;
    end
  end
end

def read_button()
  val = nil
  if @reading
    val = @sp.getc
  else
    puts "Not on the reading mode."
  end
  val.chr if val
end

def green_led()
  return 'd'
end

def red_led()
  return 'a'
end

def yellow_led()
  return 'c'
end

def blue_led()
  return 'b'
end

def close_arduino()
  @sp.close()
end
