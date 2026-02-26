const API_BASE = 'http://localhost:8080/api/qrcode/generate';

async function gerar() {
  const url = document.getElementById('url').value.trim();
  const btn = document.getElementById('btn');
  const result = document.getElementById('result');
  const error = document.getElementById('error');
  const img = document.getElementById('qr-img');
  const downloadBtn = document.getElementById('download-btn');

  if (!url) {
    alert('Informe uma URL!');
    return;
  }

  btn.disabled = true;
  btn.textContent = 'Gerando...';
  result.classList.remove('visible');
  error.classList.remove('visible');

  const apiUrl = `${API_BASE}?url=${encodeURIComponent(url)}&width=300&height=300`;

  try {
    const response = await fetch(apiUrl);
    if (!response.ok) throw new Error('Erro na API');

    const blob = await response.blob();
    const objectUrl = URL.createObjectURL(blob);

    img.src = objectUrl;
    downloadBtn.href = objectUrl;
    result.classList.add('visible');
  } catch (e) {
    error.classList.add('visible');
  } finally {
    btn.disabled = false;
    btn.textContent = 'Gerar QR Code';
  }
}

document.getElementById('url').addEventListener('keydown', (e) => {
  if (e.key === 'Enter') gerar();
});