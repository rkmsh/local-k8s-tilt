load('ext://restart_process', 'docker_build_with_restart')

mvnw = "./mvnw"
if os.name == "nt":
  mvnw = "mvnw.bat"

local_resource(
  'tengine',
  mvnw + ' package && ' +
  'rm -rf target/jar-staging && ' +
  'unzip -o target/tengine-0.0.1-SNAPSHOT.jar -d target/jar-staging && ' +
  'rsync --delete --inplace --checksum -r target/jar-staging/ target/jar',
  deps=['src/main/java', 'pom.xml', 'src/main/resources'],
  resource_deps = ['deploy'])

docker_build_with_restart(
  '172.17.0.2:5000/tengine:0.0.1',
  './target/jar',
  entrypoint=['java', '-noverify', '-cp', '.:./lib/*', 'com.webapp.tengine.TengineApplication'],
  dockerfile='./Dockerfile',
  live_update=[
    sync('./target/jar/BOOT-INF/lib', '/app/lib'),
    sync('./target/jar/META-INF', '/app/META-INF'),
    sync('./target/jar/BOOT-INF/classes', '/app'),
  ],
)


k8s_yaml('k8s/deployment.yaml')

k8s_resource('tengine-deployment', port_forwards=8080, resource_deps=['deploy', 'tengine'])
