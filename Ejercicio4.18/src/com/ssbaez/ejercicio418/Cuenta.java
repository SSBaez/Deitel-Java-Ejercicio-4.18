package com.ssbaez.ejercicio418;

import java.util.Scanner;

public class Cuenta {
	
	private int cuenta;
	private double saldoInicioMes;
	private double cargos;
	private double creditos;
	private double limiteCredito;
	
	Scanner input = new Scanner(System.in);
	
	public int getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		
			if(cuenta >= -1){
				this.cuenta = cuenta;
			}
			else{
				System.out.println("***NUMERO INVALIDO***\n");
				this.recursividadCuenta();
			}
			
	}
	
	public double getSaldoInicioMes() {
		return saldoInicioMes;
	}
	public void setSaldoInicioMes(double saldoInicioMes) {
		this.saldoInicioMes = saldoInicioMes;
	}
	
	public double getCargos() {
		return cargos;
	}
	public void setCargos(double cargos) {
		
		if(cargos >= 0){
			this.cargos = cargos;
		}
		else{
			this.recursividadCargos();
		}
		
	}
	
	public double getCreditos() {
		return creditos;
	}
	public void setCreditos(double creditos) {
		
		if(creditos >= 0){
			this.creditos = creditos;
		}
		else{
			this.recursividadCreditos();
		}
		
	}
	
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		
		if(limiteCredito >= 0){
			this.limiteCredito = limiteCredito;
		}
		else{
			this.recursividadMaxCred();
		}
		
	}
	
	public void Recibe(){
		
		int cuenta_ = 0;
		
		System.out.println("Ingrese numero de cuenta o -1 para terminar");
		System.out.print("----> ");
		cuenta_ = input.nextInt();
		this.setCuenta(cuenta_);
			
		while(this.getCuenta() != -1){
			
			System.out.printf("No. de cuenta: %d\n", this.getCuenta());
			
			System.out.println("Ingrese el saldo al inicio del mes");
			System.out.print("----> $ ");
			double saldoInicioMes_ = input.nextDouble();
			this.setSaldoInicioMes(saldoInicioMes_);
			System.out.printf("Saldo inicial: $%.2f\n", this.getSaldoInicioMes());
			
			System.out.println("Introduzca el valor total de los depositos hechos en el Mes por el cliente");
			System.out.print("----> $ ");
			double depositos_ = input.nextDouble();
			this.setCargos(depositos_);
			System.out.printf("Total de los depositos: $%.2f\n", this.getCargos());
			
			System.out.println("Introduzca el valor total de los cargos hechos en el Mes al cliente");
			System.out.print("----> $ ");
			double creditos_ = input.nextDouble();
			this.setCreditos(creditos_);
			System.out.printf("Total de los cargos: $%.2f\n", this.getCreditos());
			
			System.out.println("Ingrese el credito maximo de la cuenta");
			System.out.print("----> $ ");
			double maxCred = input.nextDouble();
			this.setLimiteCredito(maxCred);
			System.out.printf("Limite de credito: $%.2f\n", this.getLimiteCredito());
			
			double nvoSaldo = Retorna(this.saldoInicioMes, this.cargos, this.creditos);
			System.out.printf("Nuevo saldo: $%.2f\n", nvoSaldo);
			
			if(nvoSaldo + this.getLimiteCredito() < 0){
				System.out.println("***LIMITE DE CREDITO EXCEDIDO***");
			}
			
			System.out.println("\nIngrese numero de cuenta o -1 para terminar");
			System.out.print("----> ");
			cuenta_ = input.nextInt();
			this.setCuenta(cuenta_);
			
		}
		
		System.out.println("PROGRAMA FINALIZADO");
		
	}
	
	public double Retorna(double saldoInicioMes, double cargos, double creditos){
		
		return saldoInicioMes + cargos - creditos;
		
	}
	
	public void recursividadCuenta(){
		
		System.out.println("Ingrese numero de cuenta o -1 para terminar");
		System.out.print("----> ");
		int cuenta_ = input.nextInt();
		this.setCuenta(cuenta_);
		
	}
	
	public void recursividadCargos(){
		
		System.out.println("Introduzca el valor total de los depositos hechos por el cliente");
		System.out.print("----> $ ");
		double depositos_ = input.nextDouble();
		this.setCargos(depositos_);
		
	}
	
	public void recursividadCreditos(){
		
		System.out.println("Introduzca el valor total de los cargos hechos en el Mes al cliente");
		System.out.print("----> $ ");
		double cargos_ = input.nextDouble();
		this.setCreditos(cargos_);
		
	}
	
	public void recursividadMaxCred(){
		
		System.out.println("Ingrese el credito maximo de la cuenta");
		System.out.print("----> $ ");
		double maxCred = input.nextDouble();
		this.setLimiteCredito(maxCred);
		
	}
	
	

}
