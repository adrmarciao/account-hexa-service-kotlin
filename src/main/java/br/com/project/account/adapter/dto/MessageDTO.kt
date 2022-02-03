package br.com.project.account.adapter.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageDTO(@JsonProperty("message") val message: String)