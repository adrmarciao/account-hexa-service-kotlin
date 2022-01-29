package br.com.project.account.application.exception

class AccountNotFoundException(id: Long) : Error("Nenhuma conta contrado : $id")