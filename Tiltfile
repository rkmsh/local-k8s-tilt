custom_build(
    ref = '172.17.0.2:5000/tengine:0.0.1',
    command = './mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=$EXPECTED_REF -Dspring-boot.build-image.publish=true',
    deps = ['pom.xml', './src/main/java/']
)
k8s_yaml('k8s/deployment.yaml')

k8s_resource('tengine-deployment', port_forwards=8080)
