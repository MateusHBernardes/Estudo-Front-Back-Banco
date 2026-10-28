<script setup>
import { ref } from 'vue'

const ativo = ref(null)
const carregando = ref(false)
const erro = ref('')

async function consultarBoolean() {
    carregando.value = true
    erro.value = ''

    try {
        const resposta = await fetch('http://localhost:8080/boolean')
        
        ativo.value = await resposta.json()
    } catch (e) {

        erro.value = 'Não foi possível consultar a API.'
        console.error(e)
    } finally {
    carregando.value = false
    }
}
</script>

<template>
    <main>
        <h1>Meu primeiro projeto Vue + Java</h1>

        <button @click="consultarBoolean" :disabled="carregando">
            {{ carregando ? 'Consultando...' : 'Consultar PostgreSQL' }}
        </button>

        <p v-if="ativo !== null">
            Valor recebido do banco: <strong>{{ ativo }}</strong>
        </p>

        <p v-if="erro">
            {{ erro }}
        </p>
    </main>
</template>